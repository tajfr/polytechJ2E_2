/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataBase.AccessMessages;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
@WebServlet(name = "SupprimerMessageServlet", urlPatterns = {"/SupprimerMessageServlet"})
public class SupprimerMessageServlet extends HttpServlet {

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
        String alert="Votre message a été supprimé.";
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("user");
        String id = request.getParameter("id");

        AccessMessages.deleteMessage(id);
        dispatcher = request.getRequestDispatcher("SupprMess.jsp");
        
   
        dispatcher.forward(request,response);  
    }


  
}
