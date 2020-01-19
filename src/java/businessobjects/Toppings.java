/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.PizzaDL;
import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author monal
 */
@SessionScoped
public class Toppings implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String name;
    private double price;
    private Date CreateDate;
    private boolean isActive;
    private int toppingsId;

    public int getToppingsId() {
        return toppingsId;
    }

    public void setToppingsId(int toppingsId) {
        this.toppingsId = toppingsId;
    }

    public Toppings() {
    }

    public Toppings(int toppingsId,String name, double price, Date CreateDate, boolean isActive) {
        this.isActive=true;
        this.toppingsId=toppingsId;    
        this.name = name;
        this.price = price;
        this.CreateDate = CreateDate;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    String newPrice = nf.format(this.price);


    @Override
    public String toString() {
        return newPrice+" "+this.name+" "+this.isActive+" "+this.CreateDate; //To change body of generated methods, choose Tools | Templates.
    }
}
