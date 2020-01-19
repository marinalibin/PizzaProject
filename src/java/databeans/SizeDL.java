/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.Pizza;
import businessobjects.Size;
import businessobjects.Toppings;
import static com.oracle.jrockit.jfr.FlightRecorder.isActive;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class SizeDL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static Connection conn;

  private static SizeDL instance;
  
     public static SizeDL getInstance() {
        if (instance == null) {
            //first person in, we need to instantiate the object
            instance = new SizeDL();
            conn = GetConnection(); 
        }
        return instance;
    }
    
       
     //Gets list of sizes from sizes table
    public static ArrayList<Size> GetAllAvailableSizes(){
            int sizeId;
            String name;
            String sql = "select sizeid,name from sizes";
       
            try {
                PreparedStatement s = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ArrayList<Size> sizeList = new ArrayList<>();
                ResultSet rs = s.executeQuery();
                rs.first();//move cursor to the first row
                do {
                    sizeId = rs.getInt(1);
                    name = rs.getString(2);
               
                    Size size = new Size(sizeId,name);
                    sizeList.add(size);
                } while (rs.next());
                return sizeList;

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
