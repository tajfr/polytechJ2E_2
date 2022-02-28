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
class Appel {
    
    private Utilisateur client;
    private String date;

    /**
     * @return the client
     */
    public Utilisateur getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Utilisateur client) {
        this.client = client;
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
}
