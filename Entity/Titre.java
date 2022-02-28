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
public class Titre {
    
    private double ISIN;
    private int dureeValiditee;
    private int montant;

    /**
     * @return the ISIN
     */
    public double getISIN() {
        return ISIN;
    }

    /**
     * @param ISIN the ISIN to set
     */
    public void setISIN(double ISIN) {
        this.ISIN = ISIN;
    }

    /**
     * @return the dureeValiditee
     */
    public int getDureeValiditee() {
        return dureeValiditee;
    }

    /**
     * @param dureeValiditee the dureeValiditee to set
     */
    public void setDureeValiditee(int dureeValiditee) {
        this.dureeValiditee = dureeValiditee;
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
}
