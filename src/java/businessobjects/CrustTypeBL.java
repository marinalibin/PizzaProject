/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.CustTypeDL;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author monal
 */
@Stateless
public class CrustTypeBL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   private CrustType t;
   CustTypeDL custDL = CustTypeDL.getInstance();

    public CrustTypeBL() {
    }

    public CrustType getT() {
        return t;
    }

    public void setT(CrustType t) {
        this.t = t;
    }
    
    public ArrayList<CrustType> GetCrustsType(){
        return CustTypeDL.GetAllAvailableCrusts();
    }
}
