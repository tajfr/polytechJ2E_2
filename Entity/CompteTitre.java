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
public class CompteTitre extends Compte {
    
    private ArrayList<Portefeuille> portefeuilles;

    /**
     * @return the portefeuilles
     */
    public ArrayList<Portefeuille> getPortefeuilles() {
        return portefeuilles;
    }

    /**
     * @param portefeuilles the portefeuilles to set
     */
    public void setPortefeuilles(ArrayList<Portefeuille> portefeuilles) {
        this.portefeuilles = portefeuilles;
    }
}
