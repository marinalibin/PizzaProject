/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.CustomerDL;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author monal
 */
@Stateless
public class CustomerBL {

     CustomerDL customerDL= CustomerDL.getInstance();

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public static boolean AddCustomer(String fname, String lname, String contactNum,
            String email, int housenum, String street, String province, String postalCode) {

        return CustomerDL.InsertCustomer(fname, lname, contactNum, email, housenum, street, province, postalCode);
    }
    
      public static Customer GetCustomer(int id) {
        return CustomerDL.FetchCustomerById(id);
    }
    
    
}
