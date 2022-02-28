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
public class ConseillerClientele {
    
    private static final String ROLE="Conseiller clientéle";
    private ArrayList<Appel> appels;

    /**
     * @return the ROLE
     */
    public static String getROLE() {
        return ROLE;
    }

    /**
     * @return the appels
     */
    public ArrayList<Appel> getAppels() {
        return appels;
    }

    /**
     * @param appels the appels to set
     */
    public void setAppels(ArrayList<Appel> appels) {
        this.appels = appels;
    }
}
