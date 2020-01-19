/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import javax.ejb.Stateless;

/**
 *
 * @author monal
 */
@Stateless
public class Size {
    private int sizeId;
    private String name;

    public Size() {
    }

    public Size(int sizeId, String name) {
        this.sizeId = sizeId;
        this.name = name;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
