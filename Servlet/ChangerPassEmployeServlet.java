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
@WebServlet(name="ChangerPassEmployeServlet", urlPatterns="/ChangerPassEmployeServlet")
public class ChangerPassEmployeServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        String ndc = (String) session.getAttribute("numeroDeCompte");
        
        RequestDispatcher dispatcher = null;
        String message;
        if(password1.equals("") || password2.equals("")){
            message = "Erreur : Veuillez remplir tout les champs";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("ChangerPassEmploye.jsp");
        }else 
        if(!password1.equals(password2)){
            message = "Veuilez entrer deux mots de passe similaires";
            request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("ChangerPassEmploye.jsp");
        }else{
            Login.changeFirstConnection(ndc);
            Login.changePassword(ndc,password1);
            dispatcher = request.getRequestDispatcher("ValidationChangementPassword.jsp");
        }
        dispatcher.forward(request, response);
    }
    
}
