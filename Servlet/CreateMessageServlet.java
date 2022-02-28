/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataBase.AccessMessages;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 *
 * @author Taj
 */
@WebServlet(name = "CreateMessageServlet", urlPatterns = {"/CreateMessageServlet"})
public class CreateMessageServlet extends HttpServlet {
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws IOException, ServletException {
        String alert="";
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("user");
        String recepteur = request.getParameter("recepteur");
        
        String objet = request.getParameter("objet");
        String corps = request.getParameter("corpsMess");
            
        if (objet.equals("")){
            alert = "Erreur : Veuillez entrer un objet !";
            request.setAttribute("error", alert);
            dispatcher = request.getRequestDispatcher("NewMess.jsp");
        }else if (corps.equals("")){
            alert = "Erreur : Veuillez entrer un message !";
            request.setAttribute("error", alert);
            dispatcher = request.getRequestDispatcher("NewMess.jsp");
        }else{
            alert = "Envoi réalisé avec succès !";
            request.setAttribute("error", alert);
            dispatcher = request.getRequestDispatcher("NewMess.jsp");
            AccessMessages.writeMessage(login ,recepteur,objet, corps);
        }
        dispatcher.forward(request, response);
        
        
        
    }

}
