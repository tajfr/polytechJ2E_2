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

public class Ordre {
    
    @Id
    @Column(name = "ID")
    private String id;
    
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "NATURE")
    private String nature;
    
    @Column(name = "ISIN")
    private String isin;

    @Column(name = "QUANTITE")
    private String quantite;
    
    public Ordre(){
        
    }
    
    public Ordre(String id, String type, String nature, String isin, String quantite){
        this.id=id;
        this.type=type;
        this.nature=nature;
        this.isin=isin;
        this.quantite=quantite;
    }
    
}
