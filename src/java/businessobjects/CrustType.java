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
public class CrustType {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int crustTypeId;
    private String name;

    public CrustType() {
    }

    public CrustType(int crustTypeId, String name) {
        this.crustTypeId = crustTypeId;
        this.name = name;
    }

    public int getCrustTypeId() {
        return crustTypeId;
    }

    public void setCrustTypeId(int crustTypeId) {
        this.crustTypeId = crustTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
}
