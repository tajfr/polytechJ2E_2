/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataBase.NewOrder;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Taj
 */
@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/CreateOrderServlet"})
public class CreateOrderServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws IOException, ServletException {
    
    RequestDispatcher dispatcher = null;
    HttpSession session = request.getSession();
    
    String login = (String) session.getAttribute("user");
    String type = request.getParameter("type");
    String nature = request.getParameter("nature");
    String isin = request.getParameter("isin");
    String quantite = request.getParameter("quantite");
    
    
    if (type.equals("Achat")){
    
    dispatcher = request.getRequestDispatcher("GestionCompteTitre.jsp");
    NewOrder.buyOrder(type ,nature,isin, quantite,login);
    
    }
    
    else if (type.equals("Vente")){
    
    dispatcher = request.getRequestDispatcher("GestionCompteTitre.jsp");
    NewOrder.sellOrder(isin,quantite);
    }
    
    dispatcher.forward(request, response);
    
    }
}
