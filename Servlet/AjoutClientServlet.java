/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataBase.NewClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Taj
 */
@WebServlet(name = "AjoutClientServlet", urlPatterns = {"/AjoutClientServlet"})
public class AjoutClientServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws IOException, ServletException {
        
                RequestDispatcher dispatcher = null;
                HttpSession session = request.getSession();
                
                String alert="";
                
                String login="";
                
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String date = request.getParameter("dateNaissance");
                String adresse = request.getParameter("adresse");
                String mail = request.getParameter("mail");
                String tel = request.getParameter("telephone");
                
                NewClient.addClient(login, nom, prenom, date, adresse, mail, tel);
                
                //alert = "Souscription réalisée avec succès !";
                //request.setAttribute("error", alert);
                
                dispatcher = request.getRequestDispatcher("SouscrireEnLigne.jsp");
                dispatcher.forward(request, response);
    }
    
}
