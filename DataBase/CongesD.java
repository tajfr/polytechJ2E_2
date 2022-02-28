/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

/**
 *
 * @author Cyrielle
 */
public class CongesD {
    
    public static int AjoutConges(String login,String debut,String fin,int duree){   
        int status =0;
        try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();
                String id = generateRandomId();
                status=statement.executeUpdate("INSERT into Conges values('"+login+"','"+debut+"','"+fin+"',"+duree+",'En attente','"+id+"');");
              
        }catch(Exception e){e.printStackTrace();}  
        return status;  
        }
    
    public static String VisualiseConges(String login){ 
            String affichage= "";
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select * from Conges where login='"+login+"';");  
                
                while(rs.next()){
                    affichage+="<tr><td>";
                    String debut = rs.getString("debut");
                    affichage+=debut+"</td>";
                    String fin = rs.getString("fin");
                    affichage+="<td>"+fin+"</td>";
                    int duree = rs.getInt("duree");
                    affichage+="<td>"+duree+"</td>";
                    String statut = rs.getString("status");
                    affichage+="<td>"+statut+"</td>";
                    affichage+="</tr>";
                }
              
            }catch(Exception e){e.printStackTrace();}  
            return affichage;  
        }
    
    public static String ValidationConges(){ 
            String affichage= "";
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select * from Conges where status='En attente';");  
                while(rs.next()){
                    affichage+="<form name='ValidationConges' action='/JMLessous/ValidationCongesServlet' method='post' ><tr><td style='display:none'><input type='text' name='id' value='";
                    String id = rs.getString("id");
                    affichage+=id+"' readonly></td>";
                    String login = rs.getString("login");
                    affichage+="<td>"+login+"</td>";
                    String debut = rs.getString("debut");
                    affichage+="<td>"+debut+"</td>";
                    String fin = rs.getString("fin");
                    affichage+="<td>"+fin+"</td>";
                    int duree = rs.getInt("duree");
                    affichage+="<td>"+duree+"</td>";
                    affichage+="<td><br/><INPUT type='radio' name='choix' value='Valider'> Valider <br/><input type='radio' name='choix' value='Refuser'> Refuser <br/></td><td><input type='submit' name='commit' value='Valider votre choix' /></td></tr></form>";
                }
              
            }catch(Exception e){e.printStackTrace();}  
            return affichage;  
        }
    
    public static int AccepteConges(String id){   
        int status =0;
        try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                status=statement.executeUpdate("UPDATE Conges set status='Accepté' where id='"+id+"';");
              
        }catch(Exception e){e.printStackTrace();}  
        return status;  
        }
    
    public static int RefuseConges(String id){   
        int status =0;
        try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                status=statement.executeUpdate("UPDATE Conges set status='Refusé' where id='"+id+"';");
              
        }catch(Exception e){e.printStackTrace();}  
        return status;  
        }
    
    public static String generateRandomId(){
            String uniqueID = UUID.randomUUID().toString();
            return(uniqueID);
        }
    
    public static String returnLogin(String id){
         String login="";
        try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select login from Conges where id='"+id+"';");  
                
                while(rs.next()){
                   login = rs.getString("login");
                }
                
        }catch(Exception e){e.printStackTrace();}  
        return login;  
    }
    
    public static int getConges(String login){  
            int conges=0; 
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select joursconges from Employes where login='"+login+"';");  
                
                while(rs.next()){
                    conges=rs.getInt("joursconges");
                }
              
            }catch(Exception e){e.printStackTrace();}
            return conges;  
        }
    
    public static int getDuree(String id){  
            int duree=0; 
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select duree from Conges where id='"+id+"';");  
                
                while(rs.next()){
                    duree=rs.getInt("duree");
                }
              
            }catch(Exception e){e.printStackTrace();}
            return duree;  
        }
    
    public static int setConges(String login,int nbConges,int duree){
        int status =0;
        try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                int nouveauSolde = nbConges-duree;
                Statement statement=con.createStatement();  
                status=statement.executeUpdate("UPDATE Employes set joursconges='"+nouveauSolde+"' where login='"+login+"';");
              
        }catch(Exception e){e.printStackTrace();}  
        return status; 
        
    }
    
}
