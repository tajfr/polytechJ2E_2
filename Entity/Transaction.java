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
public class Transaction {
    
    private String date;
    private int montant;
    private Compte compteEmetteur;
    private Compte compteBeneficiaire;
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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
     * @return the compteEmetteur
     */
    public Compte getCompteEmetteur() {
        return compteEmetteur;
    }

    /**
     * @param compteEmetteur the compteEmetteur to set
     */
    public void setCompteEmetteur(Compte compteEmetteur) {
        this.compteEmetteur = compteEmetteur;
    }

    /**
     * @return the compteBeneficiaire
     */
    public Compte getCompteBeneficiaire() {
        return compteBeneficiaire;
    }

    /**
     * @param compteBeneficiaire the compteBeneficiaire to set
     */
    public void setCompteBeneficiaire(Compte compteBeneficiaire) {
        this.compteBeneficiaire = compteBeneficiaire;
    }

}
