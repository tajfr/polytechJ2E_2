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
public class CompteCourant extends Compte{
        private double numero;
        private double RIB;

    /**
     * @return the numero
     */
    public double getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(double numero) {
        this.numero = numero;
    }

    /**
     * @return the RIB
     */
    public double getRIB() {
        return RIB;
    }

    /**
     * @param RIB the RIB to set
     */
    public void setRIB(double RIB) {
        this.RIB = RIB;
    }
}
