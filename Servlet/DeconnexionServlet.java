/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

/**
 *
 * @author user
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class DeconnexionServlet extends HttpServlet{
    RequestDispatcher dispatcher = null;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {  
        HttpSession session = request.getSession();
        session.invalidate();
        dispatcher = request.getRequestDispatcher("Deconnexion.jsp");
        dispatcher.forward(request, response);
    }
}
