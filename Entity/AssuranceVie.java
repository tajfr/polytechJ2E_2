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
public class AssuranceVie extends ProduitBancaire {
    
    int versementInitial;
    int versementPeriodique;
    int capitalATerme;
    int tauxRendement;
    int dureeContrat;
    
    public AssuranceVie(){
        versementInitial = 0;
        versementPeriodique = 0;
        capitalATerme =0;
        tauxRendement =0;
        dureeContrat =0;
    }
    
    public AssuranceVie(int versementInitial, int versementPeriodique, int tauxRendement, int dureeContrat){
        this.versementInitial = versementInitial;
        this.versementPeriodique = versementPeriodique;
        this.tauxRendement = tauxRendement;
        this.dureeContrat = dureeContrat;
        if(tauxRendement!=0){
            capitalATerme = (versementPeriodique*12)*((((1+(tauxRendement/100))^(dureeContrat+1) - 1)*(100/tauxRendement))-1);
        }else{
            capitalATerme = 0;
        }
    }
    
    public int getVersementInit(){
        return versementInitial;
    }
    
    public int getVersementPeriodique(){
        return versementPeriodique;
    }
    
    public int getTauxRendement(){
        return tauxRendement;
    }
    
    public int getDuree(){
        return dureeContrat;
    }
    
    public int getCapitalATereme(){
        return capitalATerme;
    }
    
    public void setVersementInit(int versementI){
        versementInitial = versementI;
    }
    
    public void setVersementPeriodique(int versementP){
        versementPeriodique = versementP;
    }
    
    public void setTauxRendement(int rendement){
        tauxRendement = rendement;
    }
    
    public void setDuree(int duree){
        dureeContrat = duree;
    }
    
    public void setCapitalATerme(int capital){
        capitalATerme = capital;
    }
}
    

