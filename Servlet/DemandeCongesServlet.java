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
import javax.servlet.http.*;
import DataBase.CongesD;
import DataBase.AjoutEmploye;
import DataBase.Login;
import Entity.Employe;

/**
 *
 * @author Cyrielle
 */
@WebServlet(name = "DemandeCongesServlet", urlPatterns = {"/DemandeCongesServlet"})
public class DemandeCongesServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("user");
        String debut = request.getParameter("debut");
        String fin = request.getParameter("fin");
        String value1 = request.getParameter("duree");
        RequestDispatcher dispatcher = null;
        String message;
        
        try{
              if((Login.validateDate(debut)) && (Login.validateDate(fin))){
                int duree = Integer.parseInt(value1);

                if((debut!=null)&&(fin!=null)){
                    if(CongesD.getConges(login)>=duree){
                        int status=CongesD.AjoutConges(login,debut,fin,duree);
                        if(status==1){  
                          message="Votre congé a été demandé.";
                        }else{
                          message="Une erreur a ete commise,votre congé n'a pas été demandé.";
                        } 
                    }else{
                        message="Vous ne disposez pas d'assez de jours de congés pour demander ce congé.";
                    }
                }else{
                    message="L'un de vos paramètres est nul.";
                }
              }else{
                  message = "L'une de vos dates n'est pas valide";
              }
        }catch (NumberFormatException e){
            message = "Une erreur a été rencontrée: Verifiez que vos valeurs sont correctes !";
        }
        request.setAttribute("info", message);
        dispatcher = request.getRequestDispatcher("DemandeConges.jsp");
        dispatcher.forward(request, response);
    }

}
