/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.PizzaDL;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author monal
 */
@Stateless
public class PizzaBL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Pizza p;
    private Toppings t;

    public Toppings getT() {
        return t;
    }

    public void setT(Toppings t) {
        this.t = t;
    }

    public Pizza getP() {
        return p;
    }

    public void setP(Pizza p) {
        this.p = p;
    }

    public PizzaDL getPizzaDL() {
        return pizzaDL;
    }

    public void setPizzaDL(PizzaDL pizzaDL) {
        this.pizzaDL = pizzaDL;
    }
    PizzaDL pizzaDL=PizzaDL.getInstance();
    
      public ArrayList<Toppings> GetAllToppings() {
       return PizzaDL.GetToppings(p.getPizzaId());
   }
      
}
