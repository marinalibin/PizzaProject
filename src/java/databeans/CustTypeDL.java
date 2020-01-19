/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.CrustType;
import businessobjects.Size;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author monal
 */
@Singleton
public class CustTypeDL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static Connection conn;

  private static CustTypeDL instance;
  
     public static CustTypeDL getInstance() {
        if (instance == null) {
            //first person in, we need to instantiate the object
            instance = new CustTypeDL();
            conn = GetConnection(); 
        }
        return instance;
    }
    
       
     //Get all Crusts from crusttypes table
    public static ArrayList<CrustType> GetAllAvailableCrusts(){
            int crustTypeId;
            String name;
            String sql = "select crustTypeId,name from crusttypes";
       
            try {
                PreparedStatement s = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ArrayList<CrustType> typeList = new ArrayList<>();
                ResultSet rs = s.executeQuery();
                rs.first();//move cursor to the first row
                do {
                    crustTypeId = rs.getInt(1);
                    name = rs.getString(2);
               
                    CrustType t = new CrustType(crustTypeId,name);
                    typeList.add(t);
                } while (rs.next());
                return typeList;

            } catch (SQLException ex) {
                //swallow the exception
            }
            //only gets here if an error occurs
            return null;
     
     }
     public static Connection GetConnection() {
        //copy-paste your code
        //JDBC JavaDataBaseConnectivity
        String dbURL = "jdbc:mysql://localhost:3306/pizzadb";//port 3306, schema, type 4 driver will be used 
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ToppingsDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToppingsDL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    @PreDestroy
    private void CloseConection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PizzaDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
