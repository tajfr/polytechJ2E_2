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
public class TableauDeBord {
    
    private String nom;
    private ArrayList<Produit> produits;

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
     * @return the produits
     */
    public ArrayList<Produit> getProduits() {
        return produits;
    }

    /**
     * @param produits the produits to set
     */
    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
    
}
