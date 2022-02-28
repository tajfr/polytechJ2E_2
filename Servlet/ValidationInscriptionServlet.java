/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import DataBase.Login;

/**
 *
 * @author user
 */
@WebServlet(name="ValidationInscriptionServlet", urlPatterns="/ValidationInscriptionServlet")
public class ValidationInscriptionServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        HttpSession session = request.getSession();
        String numeroCompte = (String) session.getAttribute("numeroCompte");
        
        RequestDispatcher dispatcher = null;
        String message;
        if(login.equals("") || password1.equals("") || password2.equals("")){
            message = "Erreur : Veuillez remplir tout les champs";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Informations.jsp");
        }
        if(Login.validateLogin(login)){
            dispatcher = request.getRequestDispatcher("Informations.jsp");
            message = "Ce login est déjà attribué!";
            request.setAttribute("error", message);
        }else if(!password1.equals(password2)){
            message = "Veuilez entrer deux mots de passe similaires";
            request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Informations.jsp");
        }else{
            Login.addUser(numeroCompte,login,password1,"Client");
            Login.changeFirstConnection(numeroCompte);
            dispatcher = request.getRequestDispatcher("ValidationInscription.jsp");
        }
        dispatcher.forward(request, response);
    }
    
}
