package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
//package 

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import DataBase.Login;

@WebServlet(name="RecuperationServlet", urlPatterns="/RecuperationServlet")
public class RecuperationServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        RequestDispatcher dispatcher = null;
        String message;
        if(login.equals("")){
            message = "Erreur : Veuillez remplir tout les champs";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Recuperation.jsp");
        }else if(Login.validateLogin(login)){
            message = "Un message de récuperation de mot de passe vous à été envoyez à l'adresse: "+Login.getMail(login);
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Recuperation.jsp");
        }else{
            message = "Une erreur a été rencontrée: Nom d'utilisateur introuvable!";
            request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Recuperation.jsp");
        }
        dispatcher.forward(request, response);
    }
}
