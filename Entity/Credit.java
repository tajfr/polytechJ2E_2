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
public class Credit extends ProduitBancaire {
    
    double apportPerso;
    double montantCredit;
    double montantMensuel;
    double duree;
    double taux;
    String objetCredit;
    double capitalRestant;
    double interets;
    
    public Credit(){
       apportPerso=0;
       montantCredit=0;
       montantMensuel=0;
       duree=0;
       taux=0;
       objetCredit="";
       capitalRestant=0;
       interets=0;
    }
    
    public Credit(double apportPerso, double montantCredit, double montantMensuel, double duree,String objetCredit){
          this.apportPerso = apportPerso;
          this.montantCredit = montantCredit;
          this.montantMensuel = montantMensuel;
          this.duree= duree;
          this.objetCredit = objetCredit;
          if((objetCredit.equals("Achat")) || objetCredit.equals("Construction")){
              taux=0.042;
          }else if(objetCredit.equals("Vehicules")){
              taux=0.0214;
          }else if(objetCredit.equals("Travaux")){
              taux=0.0242;
          }else if(objetCredit.equals("Personnel")){
              taux=0.0188;
          }else{
              taux=0;
          }
          capitalRestant = montantCredit-apportPerso;
          interets =0;
    }
    
    public double getApportPerso(){
        return apportPerso;
    }
    
    public double getMontantCredit(){
        return montantCredit;
    }
    
    public double getMontantMensuel(){
        return montantMensuel;
    }
    
    public double getDuree(){
        return duree;
    }
    
     public double getTaux(){
        return taux;
    }
    
    public String getObjetCredit(){
        return objetCredit;
    }
    
    public double getInterets(){
        return interets;
    }
    
    public double capitalRestant(){
        return capitalRestant;
    }
    
    public void setApportPerso(double apport){
        apportPerso = apport;
    }
    
    public void setMontantCredit(double montant){
        montantCredit = montant;
    }
    
    public void setMontantMensuel(double montant){
        montantMensuel = montant;
    }
    
    public void getDuree(double duree){
        this.duree = duree;
    }
    
    public void setObjetCredit(String objet){
        objetCredit = objet;
    }
    
     public void setInterets(double interets){
        this.interets = interets;
    }
    
    public void capitalRestant(double capital){
        capitalRestant = capital;
    }
    
    public void nouvelleMensualiteEffectue(){
        capitalRestant-=montantMensuel;
        interets+=taux*capitalRestant;
    }
}
