package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;
import javax.persistence.EntityManager;
@WebServlet(name="MessagerieServlet", urlPatterns="/MessagerieServlet")
public class MessagerieServlet extends HttpServlet {
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        EntityManager em = null;
        
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("user");
        
        //ArrayList<Message> messageList = AccessMessages.getMessages(login);
        List messageList = em.createQuery("select * from Messages").getResultList();
        request.setAttribute("messageList",messageList);
        
        request.getRequestDispatcher("Messagerie.jsp").forward(request, response);
        
    }

}