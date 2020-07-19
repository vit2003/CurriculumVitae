/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.stokeinoutdetails;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class Stoke implements Serializable{
    
    private String id;
    private int quan;

    public Vector toVector(){
        Vector result = new Vector();
        result.add(id);
        result.add(quan);
        return result;
    }
    
    public Stoke() {
    }

    public Stoke(String id, int quan) {
        this.id = id;
        this.quan = quan;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the quan
     */
    public int getQuan() {
        return quan;
    }

    /**
     * @param quan the quan to set
     */
    public void setQuan(int quan) {
        this.quan = quan;
    }
    
    
}
