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
public class Employe extends Utilisateur {
    
    private int salaire;
    private int joursDeConges;
    private String dateEmbauche;
    private ArrayList<Formations> formations;
    private ArrayList<Conges> conges;

    
    public Employe(){
        super();
        salaire=0;
        joursDeConges=0;
        dateEmbauche="";
    }
    
    public Employe(String login,String password,String nom,String prenom,String mail,Adresse adresse,String telephone,ArrayList<Message> message,int salaire,int joursDeConges,String dateEmbauche,ArrayList<Formations> formations,ArrayList<Conges> conges){
        super(login,password,nom,prenom,mail,adresse,telephone,message);
        this.salaire = salaire;
        this.joursDeConges = joursDeConges;
        this.dateEmbauche = dateEmbauche;
        this.formations = formations;
        this.conges = conges;
    }
    /**
     * @return the salaire
     */
    public int getSalaire() {
        return salaire;
    }
    

    /**
     * @param salaire the salaire to set
     */
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    /**
     * @return the joursDeConges
     */
    public int getJoursDeConges() {
        return joursDeConges;
    }

    /**
     * @param joursDeConges the joursDeConges to set
     */
    public void setJoursDeConges(int joursDeConges) {
        this.joursDeConges = joursDeConges;
    }

    /**
     * @return the dateEmbauche
     */
    public String getDateEmbauche() {
        return dateEmbauche;
    }

    /**
     * @param dateEmbauche the dateEmbauche to set
     */
    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    
    /**
     * @return the formations
     */
    public ArrayList<Formations> getFormations() {
        return formations;
    }

    /**
     * @param formations the formations to set
     */
    public void setFormations(ArrayList<Formations> formations) {
        this.formations = formations;
    }

    /**
     * @return the conges
     */
    public ArrayList<Conges> getConges() {
        return conges;
    }

    /**
     * @param conges the conges to set
     */
    public void setConges(ArrayList<Conges> conges) {
        this.conges = conges;
    }
    
    public void utiliserJoursConges(int nombreVoulues,String dateDebut,String dateFin){
        if(nombreVoulues<=joursDeConges){
            Conges c = new Conges(dateDebut,dateFin,nombreVoulues);
            conges.add(c);
            joursDeConges-=nombreVoulues;
        }
    }
    
    public boolean assezJoursConges(int duree){
        boolean assez;
        if(duree<=joursDeConges){
            assez=true;
        }else{
            assez=false;
        }
        return assez;
    }

    
}
