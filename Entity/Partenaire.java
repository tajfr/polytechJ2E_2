/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author user
 */
public class Partenaire extends Utilisateur {
     
    private static final String ROLE="Partenaire";
    private String entreprise;

    /**
     * @return the entreprise
     */
    public String getEntreprise() {
        return entreprise;
    }

    /**
     * @param entreprise the entreprise to set
     */
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
}
