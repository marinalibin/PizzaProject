/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.ToppingsDL;
import java.io.Serializable;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author monal
 */
@Named(value="toppingBean")
@SessionScoped
public class ToppingBackingBean implements Serializable{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject 
    private Toppings toppings;

    ToppingsDL toppingsDL = ToppingsDL.getInstance();
    
    private ArrayList<String> t = new ArrayList<>();

    public ArrayList<String> getT() {
        return t;
    }

    public void setT(ArrayList<String> t) {
        this.t = t;
    }


    public Toppings getToppings() {
        return toppings;
    }

    public void setToppings(Toppings toppings) {
        this.toppings = toppings;
    }


      public ArrayList<Toppings>getAllToppings(){
        return ToppingsDL.GetAllAvailableToppings();
        
    }
      public String AddTopping(){

       if(ToppingsDL.InsertTopping(toppings)){
            return "AdminPage.xhtml";
       }
        return "";
        
    }
      
      public void RemoveTopping(){
          
          toppings.getToppingsId();
          ToppingsDL.DeleteTopping(toppings);
           System.out.println("Successfully removed");
      }
      
      public Toppings GetToppingById(int toppingId){
          return ToppingsDL.SelectTopping(toppingId);
      }
    
}
