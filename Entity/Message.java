/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Taj
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Message {
    
    @Id
    @Column(name = "ID")
    private String id;
    
    @Column(name = "LOGIN")
    private String login;
    
    @Column(name = "DEST")
    private String dest;

    @Column(name = "DATE")
    private String date;

    @Column(name = "OBJET")
    private String objet;
    
    @Column(name = "CORPS")
    private String corps;
    
    public Message(){
        
    }
    
    public Message(String id, String login, String dest, String date, String objet, String corps){
        this.id=id;
        this.login=login;
        this.dest=dest;
        this.date=date;
        this.objet=objet;
        this.corps=corps;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public String getObjet(){
        return this.objet;
    }
    
    public String getCorps(){
        return this.corps;
    }
}
