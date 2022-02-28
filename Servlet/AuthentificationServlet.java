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

@WebServlet(name="AuthentificationServlet", urlPatterns="/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String rememberCheck = request.getParameter("remember_me");
        RequestDispatcher dispatcher = null;
        String message;
        String barre = null;
        
        if(login.equals("") || password.equals("")){
            message = "Erreur : Veuillez remplir tout les champs";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Authentification.jsp");
        }else if(Login.validateAccess(login,password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("user",login);
            session.setAttribute("status",Login.getStatus(login));
            session.setAttribute("numeroDeCompte",Login.getNumeroCompte(login));
            session.setAttribute("conseiller",Login.getConseiller(login));
            if(Login.getStatus(login).equals("Client")){
                barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='GererComptesOperations.jsp'>Gerer ses comptes et operations</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            } else if(Login.getStatus(login).equals("Conseiller clientele")){
                barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='ConsulterDemandesAppels.jsp'>Consulter les demandes d'appel</a></li><li><a href='Deamndesproduits.jsp'>Visualiser les demandes de souscription</a></li<li><a href='DeamndesComptes.jsp'>Visualiser les demandes d'ouvertrue de compte</a></li><li><a href='EncoursClient.jsp'>Visualiser les encours client</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }else if(Login.getStatus(login).equals("Contrôleur de gestion")){
                barre = barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='EditionTableau.jsp'>Editer les tableaux de bord</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }else if(Login.getStatus(login).equals("Direction marketing")){
                barre = barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='CiblageClient.jsp'>Effectuer un ciblage client</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }else if(Login.getStatus(login).equals("Ressources humaines")){
                barre = barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='GererEmployes.jsp'>Gerer les employés</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }else if(Login.getStatus(login).equals("Partenaire")){
                barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }else if(Login.getStatus(login).equals("Décideur")){
                barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }else if(Login.getStatus(login).equals("Gestionnaire de patrimoine")){
                barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }else if(Login.getStatus(login).equals("Membre du directoire")){
                barre = "<li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Mon compte</a><ul class='dropdown-menu' role='menu'><li><a href='GererProfil.jsp'>Gerer son profil</a></li><li><a href='CongesE.jsp'>Gerer ses congés</a></li><li><a href='Messagerie.jsp'>Messagerie</a></li></ul><li> <a href='DeconnexionServlet'>Se déconnecter</a> </li>";
                session.setAttribute( "barre", barre );
            }
            if(Login.firstConnectionLogin(login)){
                dispatcher = request.getRequestDispatcher("ChangerPassEmploye.jsp");
            }else{
                dispatcher = request.getRequestDispatcher("Bienvenu.jsp");
            }
        }else if(Login.validateLogin(login)){
            message = "Connexion échouée, le mot de passe est incorrect!";
	    request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Authentification.jsp");
        } else{
            message = "Connexion échouée, votre nom d'utilisateur est invalide!";
            request.setAttribute("error", message);
            dispatcher = request.getRequestDispatcher("Authentification.jsp");
        }
        dispatcher.forward(request, response);
    }
}
