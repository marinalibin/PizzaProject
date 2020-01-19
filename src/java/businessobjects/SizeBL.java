/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.SizeDL;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author monal
 */
@Stateless
public class SizeBL {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Size s;
    SizeDL sizeDL = SizeDL.getInstance();

    public SizeBL() {
    }

    public Size getS() {
        return s;
    }

    public void setS(Size s) {
        this.s = s;
    }

    public SizeDL getSizeDL() {
        return sizeDL;
    }

    public void setSizeDL(SizeDL sizeDL) {
        this.sizeDL = sizeDL;
    }
    
    public ArrayList<Size> GetSizes(){
        return SizeDL.GetAllAvailableSizes();
    }
}
