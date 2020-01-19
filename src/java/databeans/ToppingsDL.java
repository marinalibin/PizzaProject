/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.Pizza;
import businessobjects.Toppings;
import java.sql.Connection;
import java.sql.Date;
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
public class ToppingsDL {
private static Connection conn;

  private static ToppingsDL instance;
  
     public static ToppingsDL getInstance() {
        if (instance == null) {
            //first person in, we need to instantiate the object
            instance = new ToppingsDL();
            conn = GetConnection(); 
        }
        return instance;
    }
     public static void InsertIntoMap(Pizza p, int pizzaId){
         ArrayList<Toppings> t = p.getToppingsId();
         for(int i =0;i<t.size();i++){
                Toppings tGet = t.get(i);
     
         String sql = "insert into pizza_toppings_map(toppingId,pizzaId)Values(?,?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1,tGet.getToppingsId());
                stmt.setInt(2, pizzaId);
   
            } catch(SQLException ex) {
                ex.printStackTrace();
               
            }
         }
         
     }
      public static boolean InsertTopping(Toppings t) {
        String sql = "INSERT INTO toppings(name, price,empAddedBy) VALUES(?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, t.getName());
            stmt.setDouble(2, t.getPrice());
            stmt.setInt(3, 1);
         

            if (stmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
      
       public static boolean DeleteTopping(Toppings t) {
        String sql = "DELETE FROM toppings where toppingId=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, t.getToppingsId());
   
            if (stmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
       //Gets name and price by toppingId 
       public static Toppings SelectTopping(int toppingId) {
        String sql = "Select price, name FROM toppings where toppingId=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, toppingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Toppings t = new Toppings();
                Float p = rs.getFloat(1);
                t.setPrice((double)p);
                t.setName(rs.getString(2));
                t.setToppingsId(toppingId);
                return t;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


     //Gets toppings from toppings table
    public static ArrayList<Toppings> GetAllAvailableToppings(){
            
            String name;
            double price;
            Date createdate;
            int isActiveInt,toppingId;
            boolean isActive=false;
            String sql = "select toppingId,name, price, createdate,isActive from toppings";
       
            try {
                PreparedStatement s = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ArrayList<Toppings> toppingsList = new ArrayList<>();
                ResultSet rs = s.executeQuery();
                rs.first();//move cursor to the first row
                do {
                    toppingId = rs.getInt(1);
                    name = rs.getString(2);
                    price = rs.getDouble(3);
                    createdate = rs.getDate(4);
                    isActiveInt=rs.getInt(5);
                    if(isActiveInt>0){
                        isActive=true;
                    }
                    Toppings t = new Toppings(toppingId,name,price,createdate,isActive);
                    toppingsList.add(t);
                } while (rs.next());
                return toppingsList;

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
