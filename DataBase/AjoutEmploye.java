package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cyrielle
 */
public class AjoutEmploye {
    
    public static boolean validateLogin(String login){  
            boolean find=false;  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select login from Users where login='"+login+"';");  
                
                while(rs.next()){
                    find=true;
                }
              
            }catch(Exception e){e.printStackTrace();}  
            return find;  
        }
    
    public static boolean validateMail(String mail){  
            boolean find=false;  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select mail from Employes where mail='"+mail+"';");  
                
                while(rs.next()){
                    find=true;
                }
              
            }catch(Exception e){e.printStackTrace();}  
            return find;  
        }
    
    public static boolean validatePhone(int numTel){  
            boolean find=false;  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                Statement statement=con.createStatement();  
                ResultSet rs=statement.executeQuery("select telephone from Employes where telephone="+numTel);  
                
                while(rs.next()){
                    find=true;
                }
              
            }catch(Exception e){e.printStackTrace();}
            return find;  
        }
    
    public static int AjoutEmploye(String login,String pass,String nom,String prenom,String mail,String adresse,int numTel,int salaire, int conges,String date,String statusE){   
        int status =0;
        try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                status=statement.executeUpdate("INSERT into Employes VALUES('"+login+"','"+pass+"','"+nom+"','"+prenom+"','"+mail+"','"+adresse+"',"+numTel+","+salaire+","+conges+",'"+date+"');");
                int statusbis = statement.executeUpdate("INSERT into users VALUES('"+login+"','"+pass+"','"+mail+"','"+statusE+"','"+login+"',true,' ');");
              
        }catch(Exception e){e.printStackTrace();}  
        return status;  
        }
}
