/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author monal
 */
@Singleton
public class EmployeeDL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static EmployeeDL instance;

    public static EmployeeDL getInstance() {
        if (instance == null) {
            //first person in, we need to instantiate the object
            instance = new EmployeeDL();
            conn = GetConnection();
        }
        return instance;
    }

    protected EmployeeDL() {
        //just so that nobody can create an instance of it
        //default constructor

    }

    private static Connection conn;

    @PreDestroy
    public void CloseConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection GetConnection() {

        String dbUrl = "jdbc:mysql://localhost:3306/pizzadb";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, username, password);
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return conn;
    }
    //Getting an employee by id from DB in the case there is more than one
    public Employee FetchEmployeeId(int id) {
            String userName, password;
            String sql = "select username, password from employee where employeeid = ?";
            try {
                //Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                PreparedStatement s = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                s.setInt(1, id);
                ResultSet rs = s.executeQuery();
                userName = rs.getString(1);
                password = rs.getString(2);
            
                Employee e = new Employee(userName, password);
                return e;

            } catch (SQLException ex) {
                //swallow the exception
            }
            //only gets here if an error occurs
            return null;

        }
            
        //Getting username and password from DB to login to admin page
         public boolean FetchEmployee(String username,String password) {
          
            String sql = "select username, password from employee where username = ? and password=?";
            try {
                //Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                PreparedStatement emp = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                emp.setString(1,username);
                emp.setString(2,password);
                
                ResultSet rs = emp.executeQuery();
                if(rs.next()){
                
                return true;
                }
                

            } catch (SQLException ex) {
                //swallow the exception
            }
            //only gets here if an error occurs
            return false;

        }

}
