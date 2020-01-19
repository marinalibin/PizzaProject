/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class CustomerDL {

  private static Connection conn;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
  private static CustomerDL instance;
  
     public static CustomerDL getInstance() {
        if (instance == null) {
            //first person in, we need to instantiate the object
            instance = new CustomerDL();
            conn = GetConnection(); 
        }
        return instance;
    }  
  //Insert customer's info to customers table
  public static boolean InsertCustomer(String fname, String lname, String contactNum,
          String email,int housenum, String street, String province, String postalCode) {
        //conn =GetConnection();
        try {
            Statement st = conn.createStatement();
            int i = st.executeUpdate("insert into customer(firstName,lastName,phoneNumber,email,houseNumber,street,province,postalCode)"
                    + "values('" + fname + "','" + lname + "','" + contactNum + "','" + email + "','" + housenum + "','" + street + "','" + province + "','" + postalCode + "')");
            System.out.println("Data is successfully inserted!" + i);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Something went wrong");
        return false;
    }

    public CustomerDL() {
        conn = GetConnection();
    }

    //Getting customer from DB by id
    public static Customer FetchCustomerById(int id) {
        String sql = "select * from customer where id =?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDL.class.getName()).log(Level.SEVERE, null, ex);
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
