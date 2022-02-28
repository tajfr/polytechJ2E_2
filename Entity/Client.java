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
public class Client extends Utilisateur {
    private static final String ROLE="Client";
    private ArrayList<Compte> comptes;
    private ConseillerClientele conseiller;

    /**
     * @return the ROLE
     */
    public static String getROLE() {
        return ROLE;
    }

    /**
     * @return the comptes
     */
    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    /**
     * @param comptes the comptes to set
     */
    public void setComptes(ArrayList<Compte> comptes) {
        this.comptes = comptes;
    }

    /**
     * @return the conseiller
     */
    public ConseillerClientele getConseiller() {
        return conseiller;
    }

    /**
     * @param conseiller the conseiller to set
     */
    public void setConseiller(ConseillerClientele conseiller) {
        this.conseiller = conseiller;
    }
    
}
