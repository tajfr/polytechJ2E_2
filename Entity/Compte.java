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
public class Compte {
    private int solde;
    private ArrayList<Client> clients;
    private ArrayList<Transaction> transactions;
    private ArrayList<Virement> virements;

    /**
     * @return the clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the virements
     */
    public ArrayList<Virement> getVirements() {
        return virements;
    }

    /**
     * @param virements the virements to set
     */
    public void setVirements(ArrayList<Virement> virements) {
        this.virements = virements;
    }

    /**
     * @return the encours
     */
    public int getSolde() {
        return solde;
    }

    /**
     * @param encours the encours to set
     */
    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    public static boolean validateMontant(int s,int m){
        return (s >= m);
    }
}
