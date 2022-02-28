/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DataBase.Login;
import Entity.Virement;
import Entity.Compte;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author user
 */
@WebServlet(name="VirementInterneServlet", urlPatterns="/VirementInterneServlet")
public class VirementInterneServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
        HttpSession session = request.getSession();
        String utilisateur = (String) session.getAttribute("user");
        String emmeteur = request.getParameter("emmeteur");
        String recepteur = request.getParameter("recepteur");
        String montant = request.getParameter("montant");    
        String date = request.getParameter("date");
        RequestDispatcher dispatcher = null;
        String message;
        if(emmeteur == null || recepteur == null || montant.length() == 0 || date.length() == 0){
            message = "Erreur : Veuillez remplir tout les champs";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("VirementInterne.jsp");
        }else if(emmeteur.equals(recepteur)){
            message = "Erreur : Impossible d'effectuer un virement sur le même compte";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("VirementInterne.jsp");
        }else{
            int solde1 = Login.getSolde((String) session.getAttribute("user"),emmeteur);
            int solde2 = Login.getSolde((String) session.getAttribute("user"),recepteur);
            int montantInt =Integer.parseInt(request.getParameter("montant"));
            if(montantInt < 0){
                message = "Erreur : Vous ne pouvez pas virer une somme négative";
                request.setAttribute("error", message);
                dispatcher = request.getRequestDispatcher("VirementInterne.jsp");
            }
            else if(!Compte.validateMontant(solde1, montantInt)){
                message = "Erreur : Vous ne disposez pas de suffisamment de fonds pour effectuer ce virement";
                request.setAttribute("error", message);
                dispatcher = request.getRequestDispatcher("VirementInterne.jsp");
            }else{  
                if (!Login.validateDate(date)){    
                    message = "Erreur : La date selectionné pour le virement est incohérente";
                    request.setAttribute("error", message);
                    dispatcher = request.getRequestDispatcher("VirementInterne.jsp");
                }
                else{
                    Login.updateSolde(utilisateur,emmeteur, solde1-montantInt);
                    Login.updateSolde(utilisateur,recepteur, solde2+montantInt);
                    Login.saveVirement(utilisateur, recepteur, emmeteur, montant, date);
                    message = "Votre virement à été effectué!";
                    request.setAttribute("error", message);
                    dispatcher = request.getRequestDispatcher("VirementInterne.jsp");
                }
            }  
        }
        dispatcher.forward(request, response);
    }
}