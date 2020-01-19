/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author monal
 */
public class Order {
    private double totalPrice;
    private String orderStatus;
    private Date deliveryDateTime;
    private Date placeDateTime; 
    private boolean isFinished;
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    private ArrayList<Pizza> pizzas;

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Order() {

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalProce(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(Date deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public Date getPlaceDateTime() {
        return placeDateTime;
    }

    public void setPlaceDateTime(Date placeDateTime) {
        this.placeDateTime = placeDateTime;
    }
    
  
    public boolean UpdateOrder(){
        return true;
    }
    
    //Calculates total price for order
    public double GetTotalPrice(){
        double sum=0.0;
        
        for(int i =0;i<pizzas.size();i++){
            Pizza pizzaGet = pizzas.get(i);
            sum+=pizzaGet.CalculatePrice();
            for(int x =0;x<pizzaGet.getToppingsId().size();x++){
                Toppings topppingsGet = pizzaGet.getToppingsId().get(x);
                sum+=topppingsGet.getPrice();
            }
        
        
        }
        
        return sum*1.15;
    
    }
  
    
}
