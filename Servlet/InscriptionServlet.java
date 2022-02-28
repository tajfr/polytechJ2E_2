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

@WebServlet(name="InscriptionServlet", urlPatterns="/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String numeroCompte = request.getParameter("Numero de compte");
        RequestDispatcher dispatcher = null;
        String message;
        HttpSession session = request.getSession(true);
        if(numeroCompte.equals("")){
            message = "Erreur : Veuillez remplir tout les champs";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Inscription.jsp");
        }else if(Login.validateAccountNumber(numeroCompte) && Login.firstConnection(numeroCompte)){
            session.setAttribute("numeroCompte",numeroCompte);
            dispatcher = request.getRequestDispatcher("Informations.jsp");
        }else if(Login.validateAccountNumber(numeroCompte) && !Login.firstConnection(numeroCompte)){
            message = "Vous avez déjà un compte sur notre site!";
            request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Inscription.jsp");
        }else{
            message = "Nous n'avons pas de client associé à ce numéro de compte!";
            request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Inscription.jsp");
        }
        dispatcher.forward(request, response);
    }
}
