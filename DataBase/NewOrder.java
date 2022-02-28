/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author Taj
 */

import static DataBase.AccessMessages.generateRandomId;
import static DataBase.AccessMessages.getDate;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

public class NewOrder {
    
    public static String generateRandomId(){
            String uniqueID = UUID.randomUUID().toString();
            return(uniqueID);
     }
    
    public static int buyOrder(String type, String nature,String isin,String quantite, String login){   
                int statut=0;
        try{ 
                
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String id = generateRandomId();
                statut = state.executeUpdate( "INSERT INTO ordres VALUES ('"+id+"','"+type+"','"+nature+"', '"+isin+"', '"+quantite+"', '"+login+"');", Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = state.getGeneratedKeys();           
        }catch(Exception e){e.printStackTrace();}  
                return statut;
        }
    
    public static int sellOrder(String isin, String q1){   
                int statut=0;
        try{ 
                int q = Integer.parseInt(q1);
            
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                
                String query="select quantite from public.ordres where isin='"+isin+"';";          
                ResultSet rs=state.executeQuery(query);
                String q4 = rs.getString("quantite");
                int qq = Integer.parseInt(rs.getString("quantite"));
                
                
                if (q1.equals(q4)){
                    String query1 = "DELETE FROM public.ordres WHERE isin='"+isin+"';";
                    Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1=statement.executeQuery(query1);
                    rs1.next();     
                    rs1.updateRow();
                    rs1.close();
                    statement.close();
                }else if(q<qq){
                    int qqq = qq-q;
                    String qqqq = String.valueOf(qqq);
                    String query2 = "SELECT * FROM public.orders WHERE isin='"+isin+"';";
                    Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs2=statement.executeQuery(query2);
                    rs2.updateString("quantite", qqqq);
                    rs2.next();     
                    rs2.updateRow();
                    rs2.close();
                    statement.close();
                }
                
                //ResultSet rs1 = state.getGeneratedKeys();           
        }catch(Exception e){e.printStackTrace();}  
                return statut;
        }
    
    public static String getOrdres(String login){
            String affichage= "";
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                
                ResultSet rs=statement.executeQuery("select * from public.ordres where login='"+login+"';");  
               
                while(rs.next()){
                    affichage+="<tr>";   
                    affichage+="<td>"+rs.getString("nature")+"</td>";
                    affichage+="<td>"+rs.getString("isin")+"</td>";
                    affichage+="<td>"+rs.getString("quantite")+"</td>";
                    affichage+="</tr>";
                }
              
            }catch(Exception e){e.printStackTrace();}  
            return affichage;  
        }
    
}
