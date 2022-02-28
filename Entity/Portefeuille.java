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
class Portefeuille {
    
    private String nom;
    private int montant;
    private int nbTitres;
    private ArrayList<Titre> Titres;

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
     * @return the montant
     */
    public int getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(int montant) {
        this.montant = montant;
    }

    /**
     * @return the nbTitres
     */
    public int getNbTitres() {
        return nbTitres;
    }

    /**
     * @param nbTitres the nbTitres to set
     */
    public void setNbTitres(int nbTitres) {
        this.nbTitres = nbTitres;
    }

    /**
     * @return the Titres
     */
    public ArrayList<Titre> getTitres() {
        return Titres;
    }

    /**
     * @param Titres the Titres to set
     */
    public void setTitres(ArrayList<Titre> Titres) {
        this.Titres = Titres;
    }
}
