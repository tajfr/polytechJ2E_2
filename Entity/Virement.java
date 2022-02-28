/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class Virement {
    
    private String date;
    private int montant;
    private Compte compteEmetteur;
    private Compte compteBeneficiaire;
    
    public Virement(Compte e, Compte b, int m, String d){
        this.compteEmetteur=e;
        this.compteBeneficiaire=b;
        this.montant=m;
        this.date=d;
    }

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
    
    public boolean isOlder(Virement v){
        boolean older=true;
        String d1=this.getDate();
        String d2=v.getDate();
        if(Integer.parseInt(d1.substring(6,10)) > Integer.parseInt(d2.substring(6,10))){
            older=false;
        }else if(Integer.parseInt(d1.substring(6,10)) < Integer.parseInt(d2.substring(6,10))){
            older=true;
        }else{
            if(Integer.parseInt(d1.substring(3,5)) > Integer.parseInt(d2.substring(3,5))){
                older=false;
            }else if(Integer.parseInt(d1.substring(3,5)) < Integer.parseInt(d2.substring(3,5))){
                older=true;
            }else{
                if(Integer.parseInt(d1.substring(0,2)) > Integer.parseInt(d2.substring(0,2))){
                    older=false;
                }else if(Integer.parseInt(d1.substring(0,2)) < Integer.parseInt(d2.substring(0,2))){
                    older=true;
                }
            }
        }
        return(older);
    }
}
