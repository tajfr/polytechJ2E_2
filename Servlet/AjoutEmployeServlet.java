/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataBase.AjoutEmploye;
import DataBase.Login;
import Entity.Credit;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Cyrielle
 */
@WebServlet(name = "AjoutEmployeServlet", urlPatterns = {"/AjoutEmployeServlet"})
public class AjoutEmployeServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String nom = request.getParameter("nom");
        String pass = request.getParameter("pass");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String adresse = request.getParameter("adresse");
        String value1 = request.getParameter("telephone");
        String value2 = request.getParameter("salaire");
        String value3 = request.getParameter("conges");
        String fonction = request.getParameter("fonction");
        String date = request.getParameter("date");
        RequestDispatcher dispatcher = null;
        String message;
        
        try{
            
              int telephone = Integer.parseInt(value1);
              int salaire = Integer.parseInt(value2);
              int conges = Integer.parseInt(value3);
              
              if((login!=null)&&(nom!=null)&&(prenom!=null)&&(mail!=null)&&(adresse!=null)&&(date!=null)){
                  if(Login.validateDate(date)){
                    if(!(AjoutEmploye.validateLogin(login)) && !(AjoutEmploye.validateMail(mail)) && !(AjoutEmploye.validatePhone(telephone))){
                            AjoutEmploye.AjoutEmploye(login,pass, nom, prenom, mail, adresse, telephone, salaire, conges, date,fonction);
                            message="Employé correctement ajouté";
                    }else{
                        message="L'un de vos paramètres est deja utilise par un autre employe";
                    }
                  }else{
                      message="Votre date n'est pas valide";
                  }
                }else{
                    message="L'un de vos paramètres est nul";
                }
        }catch (NumberFormatException e){
            message ="Une erreur a été rencontrée: Verifiez que vos valeurs sont des chiffres !";
        }
        request.setAttribute("info", message);
        dispatcher = request.getRequestDispatcher("Employes.jsp");
        dispatcher.forward(request, response);
    }


}
