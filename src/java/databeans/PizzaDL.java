/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.Order;
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
public class PizzaDL {
private static Connection conn;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

  private static PizzaDL instance;
  
     public static PizzaDL getInstance() {
        if (instance == null) {
            //first person in, we need to instantiate the object
            instance = new PizzaDL();
            conn = GetConnection(); 
        }
        return instance;
    }
     //Insert pizza to DB after customer hits place order button   
     public static void placePizza(Order o,int orderId){
         ArrayList<Pizza> p=o.getPizzas();
         int isFinishedOrder =0;
            for(int i =0;i<p.size();i++){
                Pizza pGet = p.get(i);
                 String sql = "INSERT INTO pizza(sizeId, isFinished, crustTypeId,price,orderId) VALUES(?, ?, ?, ?,?)";

            try {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                stmt.setDouble(1,pGet.getPrice());
             if(pGet.isIsFinished()==true){
                    isFinishedOrder=1;
                    
                }
                stmt.setInt(2, isFinishedOrder);
                stmt.setInt(3, pGet.getCrustType());
                stmt.setDouble(4, pGet.getPrice());
                stmt.setInt(4, pGet.getOrderId());

                int iterate =stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                while(rs.next()){
                
                    ToppingsDL.InsertIntoMap(pGet,rs.getInt(1));
                }
             
            } catch(SQLException ex) {
                ex.printStackTrace();
               
            }
           }
         
     }
   
   //List of available toppings     
   public static ArrayList<Toppings> GetToppings(int pizzaId){
       String name;
       float price;
       Date createDate;
       boolean isActive;
       String sql = "select toppings.name,toppings.price,toppings.createdate,toppings.isActive,pizza_toppings_map.pizzaId from toppings"
               + " INNER JOIN pizza_toppings_map on toppings.toppingId= pizza_toppings_map.toppingId where pizzaId="+pizzaId;
       try{
           PreparedStatement s = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
          
              ArrayList<Toppings> toppingsList = new ArrayList<>();
                ResultSet rs = s.executeQuery();
                rs.first();//move cursor to the first row
                do {
                  
                    name = rs.getString(1);
                    price = rs.getFloat(2);
                    createDate = rs.getDate(3);
                    isActive=rs.getBoolean(4);
                    Toppings t = new Toppings(0,name, price, createDate, isActive);
                    toppingsList.add(t);
                } while (rs.next());
                return toppingsList;
       }
       catch (SQLException ex) {
                //swallow the exception
            }
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
            Logger.getLogger(PizzaDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PizzaDL.class.getName()).log(Level.SEVERE, null, ex);
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
