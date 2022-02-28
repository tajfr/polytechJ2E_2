/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import static DataBase.AccessMessages.generateRandomId;
import static DataBase.AccessMessages.getDate;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

/**
 *
 * @author Taj
 */
public class NewClient {
    
    public static int addClient(String login, String nom, String prenom,String date,String adresse, String mail, String tel){   
                int statut=0;
        try{ 
                
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                statut = state.executeUpdate( "INSERT INTO clients VALUES ('"+login+"','"+nom+"','"+prenom+"', '"+date+"', '"+adresse+"', '"+mail+"', '"+tel+"');", Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = state.getGeneratedKeys();
                
        }catch(Exception e){e.printStackTrace();}  
                return statut;
        }
    
}
