/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author monal
 */
@Singleton
public class OrderDL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static Connection conn;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

  private static OrderDL instance;
  
     public static OrderDL getInstance() {
        if (instance == null) {
            //first person in, we need to instantiate the object
            instance = new OrderDL();
            conn = GetConnection(); 
        }
        return instance;
    }
     
     //Place order in the Order Table
     public static void CreateOrder(Order o){
               
 
         String sql = "INSERT INTO orders(totalPrice, deliveryDateTime, placedDateTime,customerId,orderStatus) VALUES(?, ?, ?, ?,?)";

            try {
                PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

                stmt.setFloat(1, (float)o.getTotalPrice());
                stmt.setDate(2, o.getDeliveryDateTime());
                stmt.setDate(3, o.getPlaceDateTime());
                stmt.setInt(4, o.getCustomerId());
                stmt.setString(5,o.getOrderStatus());
                
                int i =stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                while(rs.next()){
                    PizzaDL.placePizza(o, rs.getInt(1));
                }
                
         
         
     }  catch (SQLException ex) {
            Logger.getLogger(OrderDL.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(OrderDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    @PreDestroy
    private void CloseConection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
