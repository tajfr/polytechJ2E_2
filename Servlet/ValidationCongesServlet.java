/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataBase.AjoutEmploye;
import DataBase.CongesD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cyrielle
 */
@WebServlet(name = "ValidationCongesServlet", urlPatterns = {"/ValidationCongesServlet"})
public class ValidationCongesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String choix = request.getParameter("choix");
        RequestDispatcher dispatcher = null;
        String message;
        
        try{
            if(choix.equals("Valider")){
                if(id!=null){
                    CongesD.AccepteConges(id);
                    String login = CongesD.returnLogin(id);
                    int duree = CongesD.getDuree(id);
                    int nbConges = CongesD.getConges(login);
                    CongesD.setConges(login, nbConges, duree);
                    message="Les congés ont été acceptés";
                }else{
                    message="Votre id n'est pas valide";
                }
            }else if(choix.equals("Refuser")){
                if(id!=null){
                    CongesD.RefuseConges(id);
                    message="les conges ont bien été refusés";
                }else{
                message="Votre id n'est pas valide";
                }
            }else{
                 message="Une erreur s'est produite";   
            }
              
        }catch (NumberFormatException e){
            message ="Une erreur a été rencontrée: Verifiez vos manipulations !";
        }
        request.setAttribute("info", message);
        dispatcher = request.getRequestDispatcher("Conges.jsp");
        dispatcher.forward(request, response);
    }

}
