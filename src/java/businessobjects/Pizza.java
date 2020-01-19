/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author monal
 */
@Stateless
public class Pizza {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int crustType;
    private boolean isFinished;
    private String size;
    private double price;
    private int orderId;
    private ArrayList<Toppings> toppingsId;
    private int pizzaId;



    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public ArrayList<Toppings> getToppingsId() {
        return toppingsId;
    }

    public void setToppingsId(ArrayList<Toppings> toppingsId) {
        this.toppingsId = toppingsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Pizza() {
    }
    
    

    public int getCrustType() {
        return crustType;
    }

    public void setCrustType(int crustType) {
        this.crustType = crustType;
    }

    public boolean isIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
   public double CalculatePrice(){
         
     if(this.crustType==1){
           this.price+=5;
       }
       else if(this.crustType==2){
           this.price+=6;
       }
       else if(this.crustType==3){
           this.price+=7;
       }
         else if(this.crustType==4){
           this.price+=7;
       }
         else if(this.size.equalsIgnoreCase("Small")){
           this.price+=10.99;
       }
       else if(this.size.equalsIgnoreCase("Medium")){
           this.price+=11.99;
       }
       else if(this.size.equalsIgnoreCase("Large")){
           this.price+=12.99;
       }
        return this.price*1.15;
     }

    @Override
    public String toString() {
        return Integer.toString(this.crustType)+" "+Double.toString(this.price)+" "+this.toppingsId; //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
