package DataBase;

import java.sql.*;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
      
    public class Login {  
        
        public static String generateRandomId(){
            String uniqueID = UUID.randomUUID().toString();
            return(uniqueID);
        }
        
        public static boolean firstConnection(String accountNumber){
            boolean firstConnection=true;
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select premiereConnection from Users where numeroDeCompte=?");  
                ps.setString(1,accountNumber);   
          
                ResultSet rs=ps.executeQuery();  
                rs.next();
                firstConnection=rs.getBoolean("premiereConnection");
              
            }catch(Exception e){e.printStackTrace();} 
            return (firstConnection);
        }
        
        public static boolean firstConnectionLogin(String login){
            boolean firstConnection=true;
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select premiereConnection from Users where login=?");  
                ps.setString(1,login);   
          
                ResultSet rs=ps.executeQuery();  
                rs.next();
                firstConnection=rs.getBoolean("premiereConnection");
              
            }catch(Exception e){e.printStackTrace();} 
            return (firstConnection);
        }
        
        public static boolean validateAccountNumber(String accountNumber){
            boolean validate=true;
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select * from Users where numeroDeCompte=?");  
                ps.setString(1,accountNumber);   
          
                ResultSet rs=ps.executeQuery();  
                validate=rs.next();  
              
            }catch(Exception e){e.printStackTrace();} 
            return (validate);
        }
        
        public static void addUser(String ndc,String login, String pass, String status){
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String query="Select * from Users where numeroDeCompte="+"'"+ndc+"'";          
                ResultSet rs=state.executeQuery(query);
                rs.next();     
                rs.updateString("login", login);
                rs.updateString("pass", pass);
                rs.updateString("status", status);
                rs.updateRow();
                rs.close();
                state.close();
            }catch(Exception e){e.printStackTrace();}  
        }
        
        public static void changeFirstConnection(String ndc){
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String query="Update Users SET premiereConnection='"+false+"' where numeroDeCompte='"+ndc+"'";          
                ResultSet rs=state.executeQuery(query);
                rs.next();     
                rs.updateRow();
                rs.close();
                state.close();
            }catch(Exception e){e.printStackTrace();}  
        }
        
        public static void changePassword(String ndc,String password){
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
                String query="Update Users SET pass='"+password+"' where numeroDeCompte='"+ndc+"'";          
                ResultSet rs=state.executeQuery(query);
                rs.next();     
                rs.updateRow();
                rs.close();
                state.close();
            }catch(Exception e){e.printStackTrace();} 
        }
        
        public static boolean validateAccess(String login,String pass){  
            boolean status=false;  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select * from Users where login=? and pass=?");  
                ps.setString(1,login);  
                ps.setString(2,pass);  
          
                ResultSet rs=ps.executeQuery();  
                status=rs.next();  
              
            }catch(Exception e){e.printStackTrace();}  
            return status;  
        }  
        
        public static boolean validateLogin(String login){  
            boolean status=false;  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select * from Users where login=?");  
                ps.setString(1,login);   
          
                ResultSet rs=ps.executeQuery();  
                status=rs.next();  
              
            }catch(Exception e){e.printStackTrace();}  
            return status;  
        }
        
        public static String getMail(String login){
            String mail = "";  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select mail from Users where login=?");  
                ps.setString(1,login);  
          
                ResultSet rs=ps.executeQuery();
                rs.next();
                mail=rs.getString("mail");
              
            }catch(Exception e){e.printStackTrace();}  
            return mail;  
        }
        
        public static String getNumeroCompte(String login){
            String status = "";  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select numeroDeCompte from Users where login=?");  
                ps.setString(1,login);  
          
                ResultSet rs=ps.executeQuery();
                rs.next();
                status=rs.getString("numeroDeCompte");
              
            }catch(Exception e){e.printStackTrace();}  
            return status;
        }
        
        public static String getConseiller(String login){
            String status = "";  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select conseiller from Users where login=?");  
                ps.setString(1,login);  
          
                ResultSet rs=ps.executeQuery();
                rs.next();
                status=rs.getString("conseiller");
              
            }catch(Exception e){e.printStackTrace();}  
            return status; 
        }
        
        public static String getStatus(String login){
            String status = "";  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select status from Users where login=?");  
                ps.setString(1,login);  
          
                ResultSet rs=ps.executeQuery();
                rs.next();
                status=rs.getString("status");
              
            }catch(Exception e){e.printStackTrace();}  
            return status;
        }
        
        public static int getSolde(String login,String type){
            int solde = 0;  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
          
                PreparedStatement ps=con.prepareStatement(  
                "select solde from Comptes where proprietaire=? and typeCompte =?");  
                ps.setString(1,login);
                ps.setString(2,type);
          
                ResultSet rs=ps.executeQuery();
                rs.next();
                solde=Integer.parseInt(rs.getString("solde"));
              
            }catch(Exception e){e.printStackTrace();}  
            return solde;
        }
        
        public static boolean validateDate(String d){
            SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
            df.setLenient(false);
            try {
                java.util.Date date = df.parse(d);
                return true;
            }   catch (ParseException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        public static void updateSolde(String login,String type,int newValue){
            int solde = 0;  
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);      
                String query="Update Comptes SET solde='"+newValue+"' where login='"+login+"' and typeCompte='"+type+"'";          
                ResultSet rs=state.executeQuery(query);
                rs.next();     
                rs.updateRow();
                rs.close();
                state.close();
            }catch(Exception e){e.printStackTrace();}  
        }
        
        public static void saveVirement(String utilisateur,String recepteur,String emmeteur,String montant,String date){
            try{  
                Class.forName("org.postgresql.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:postgresql://localhost:5432/JMLessous","postgres","souktani");  
                Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String id = generateRandomId();
                int statut = state.executeUpdate( "INSERT INTO Virement VALUES ('"+id+"','"+utilisateur+"','"+recepteur+"', '"+emmeteur+"', '"+date+"', '"+montant+"');", Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = state.getGeneratedKeys();
            }catch(Exception e){e.printStackTrace();}  
        }
    }  