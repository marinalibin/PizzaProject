/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.OrderDL;
import javax.ejb.Stateless;

/**
 *
 * @author monal
 */
@Stateless
public class OrderBL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Order o;
    OrderDL orderDL= OrderDL.getInstance();

    public OrderBL() {
    }

    public Order getO() {
        return o;
    }

    public void setO(Order o) {
        this.o = o;
    }
    
//    public static void InsertOrder(){
//        return OrderDL.CreateOrder(Order order);
//    }
    

}
