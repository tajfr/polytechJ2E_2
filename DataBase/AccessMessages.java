/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

public class AccessMessages {
    
     public static String generateRandomId(){
            String uniqueID = UUID.randomUUID().toString();
            return(uniqueID);
     }
     
     public static String getDate(){
         Locale locale = Locale.getDefault();
	 java.util.Date actuelle = new java.util.Date();
         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
         String dat = dateFormat.format(actuelle);
         return(dat);
     }
             
     public static String getMessages(String login){
            String affichage= "";
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                
                ResultSet rs=statement.executeQuery("select * from public.messages where dest='"+login+"';");  
               
                while(rs.next()){
                    affichage+="<tr>";   
                    affichage+="<td>"+rs.getString("login")+"</td>";
                    String dest = rs.getString("Dest");
                    affichage+="<td>"+dest+"</td>";
                    String date = rs.getString("Date");
                    affichage+="<td>"+date+"</td>";
                    String objet = rs.getString("Objet");
                    affichage+="<td>"+objet+"</td>";
                    String corps = rs.getString("Corps");
                    affichage+="<td>"+corps+"</td>";
                    affichage+="</tr>";
                }
              
            }catch(Exception e){e.printStackTrace();}  
            return affichage;  
        }
     
     public static String getMessagesEnvoyes(String login){
            String affichage= "";
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                
                ResultSet rs=statement.executeQuery("select * from public.messages where login='"+login+"';");  
               
                while(rs.next()){
                    affichage+="<tr>";   
                    affichage+="<td>"+rs.getString("login")+"</td>";
                    String dest = rs.getString("Dest");
                    affichage+="<td>"+dest+"</td>";
                    String date = rs.getString("Date");
                    affichage+="<td>"+date+"</td>";
                    String objet = rs.getString("Objet");
                    affichage+="<td>"+objet+"</td>";
                    String corps = rs.getString("Corps");
                    affichage+="<td>"+corps+"</td>";
                    affichage+="</tr>";
                }
              
            }catch(Exception e){e.printStackTrace();}  
            return affichage;  
        }
     
     public static String getMessagesToDelete(String login){
            String affichage= "";
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
                Statement statement=con.createStatement();  
                
                ResultSet rs=statement.executeQuery("select * from public.messages where dest='"+login+"' or login='"+login+"';");  
     
                while(rs.next()){
                    affichage+="<tr><form name='SuppMess' action='SupprimerMessageServlet' method='post' ><td style=\"display:none\"><input type='hidden' name='id' value='";
                
                    affichage+=rs.getString("ID")+"' readonly></td>";
                    affichage+="<td>"+rs.getString("login")+"</td>";
                    String dest = rs.getString("dest");
                    affichage+="<td>"+dest+"</td>";
                    String date = rs.getString("Date");
                    affichage+="<td>"+date+"</td>";
                    String objet = rs.getString("Objet");
                    affichage+="<td>"+objet+"</td>";
                    String corps = rs.getString("Corps");
                    affichage+="<td>"+corps+"</td>";
                    affichage+="<td><input type=\"submit\" name=\"i\" value=\"X\"></td></form></tr>";
                }
            }catch(Exception e){e.printStackTrace();}  
            return affichage;  
        }
     
    
     public static int writeMessage(String emmeteur, String destinataire,String objet,String corps){   
                int statut=0;
        try{ 
                
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String id = generateRandomId();
                String date = getDate();
                statut = state.executeUpdate( "INSERT INTO messages VALUES ('"+id+"','"+emmeteur+"','"+destinataire+"', '"+date+"', '"+objet+"', '"+corps+"');", Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = state.getGeneratedKeys();           
        }catch(Exception e){e.printStackTrace();}  
                return statut;
        }
     
     public static void deleteMessage(String id){
         try{
        Class.forName("org.postgresql.Driver");  
        Connection con=DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");
        Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
        //statement.executeQuery("DELETE FROM messages WHERE ID='"+id+"';");
        String query = "DELETE FROM messages WHERE ID='"+id+"';";
        ResultSet rs=statement.executeQuery(query);
        rs.next();     
        rs.updateRow();
        rs.close();
        statement.close();
        }catch(Exception e){e.printStackTrace();}  
        
         
    }
     
     public static String getDestinatairesConseiller(String login){
         String affichage="<select name=\"recepteur\" id=\"dest\">";
        try{  
            Class.forName("org.postgresql.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                
            Statement statement=con.createStatement();  
                
            ResultSet rs=statement.executeQuery("select * from users where conseiller='"+login+"';");  
     
                while(rs.next()){
                    affichage+="<option value='"+rs.getString("login")+"'>"+rs.getString("login")+"</option>";
                }
                affichage+="</select>";
            }catch(Exception e){e.printStackTrace();}  
            return affichage;
         
     }
}
