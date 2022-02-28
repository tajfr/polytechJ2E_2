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

/**
 *
 * @author user
 */
@WebServlet(name="NavigationBarServlet", urlPatterns="/NavigationBarServlet")
public class NavigationBarServlet extends HttpServlet {
    RequestDispatcher dispatcher = null;
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
        HttpSession session = request.getSession();
        String barre = (String) session.getAttribute("barre");
        if (barre == null){
            barre = "<li> <a href='Authentification.jsp'>Se connecter</a> </li><li> <a href='Inscription.jsp'>S'inscrire</a> </li>";
        }
        request.setAttribute("barre", barre);
    }
}
