/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.Credit;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cyrielle
 */
@WebServlet(name = "CreditImmoServlet", urlPatterns = {"/CreditImmoServlet"})
public class CreditImmoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String objetCredit = request.getParameter("objet");
        String value1 = request.getParameter("montant");
        String value2 = request.getParameter("apport");
        String value3 = request.getParameter("montantDemande");
        String value5 = request.getParameter("revenus");
        String value6 = request.getParameter("charges");
        String value7 = request.getParameter("montantCredit");
        String value8 = request.getParameter("duree");
        RequestDispatcher dispatcher = null;
        String message;
        
        try{
            
              double montantTransaction = Double.parseDouble(value1);
              double apport = Double.parseDouble(value2);
              double montantDemande = Double.parseDouble(value3);
              double revenus = Double.parseDouble(value5);
              double charges = Double.parseDouble(value6);
              double montantCredit = Double.parseDouble(value7);
              double duree=Double.parseDouble(value8);
              double capaciteEndettement = 0.33*revenus;
              double montantMensuel = montantDemande/duree/12;
              double fondsRestants = revenus - charges - montantCredit -montantMensuel;
              
              Credit simu = new Credit(apport,montantDemande,montantMensuel,duree,objetCredit);
              
              if(simu.getTaux()!=0){
                if((montantMensuel!=0) && (revenus!=0) && (apport!=0)){
                    if(montantDemande<=montantTransaction){
                        if(fondsRestants>0){
                            message="Si vous souscrivez à ce crédit un taux de "+simu.getTaux()+"%/an sera appliqué. Vous devrez rembourser "+montantMensuel+"€/mois et vos revenus mensuels après remboursement cette mensualité s'éleveront à "+
                                fondsRestants+"€";
                        }else if(fondsRestants+capaciteEndettement>0){
                            message="Vos revenus ne sont pas suffisants pour souscrire à ce crédit, cependant la banque accepte un endettement égale à "+
                                    "33% de vos revenus, en utilisant cet avantage vous pouvez souscrire à ce crédit qui aura un taux de "+simu.getTaux()+"%/an.";
                        }else{
                            message="Vos revenus ne sont pas suffisants pour souscrire à ce crédit.";
                        }
                    }else{
                        message="Le montant demande ne doit pas être plus grand que le montant de la transaction à effectuer.";
                    }
                }else{
                    message="Le montant mensuel à rembourser, le revenu et l'apport ne peuvent pas être nul."; 
                }
              }else{
                  message=objetCredit+"L'objet du crédit n'est pas valide veuillez taper Achat ou Construction.";
              }
        }catch (NumberFormatException e){
            message = "Une erreur a été rencontrée: Verifiez que vos valeurs sont des chiffres !";
        }
        request.setAttribute("info", message);
        dispatcher = request.getRequestDispatcher("SimulerCreditImmo.jsp");
        dispatcher.forward(request, response);
    }

}
