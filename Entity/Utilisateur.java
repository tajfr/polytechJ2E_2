/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Utilisateur {
    
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String mail;
    private Adresse adresse;
    private String telephone;
    private ArrayList<Message> message;
    
     public Utilisateur(){
        this.login = "";
        this.password = "";
        this.nom = "";
        this.prenom = "";
        this.mail = "";
        this.telephone = "";
    }
    
    public Utilisateur(String login,String password,String nom,String prenom,String mail,Adresse adresse,String telephone,ArrayList<Message> message){
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.telephone = telephone;
        this.message = message;
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prénom
     */
    public String getPrénom() {
        return prenom;
    }

    /**
     * @param prénom the prénom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the message
     */
    public ArrayList<Message> getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(ArrayList<Message> message) {
        this.message = message;
    }


}