/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.bill;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class BillDTO implements Serializable{
    
    private String id, userid, date;
    private float total;

    public BillDTO() {
    }

    public BillDTO(String id, String userid, String date, float total) {
        this.id = id;
        this.userid = userid;
        this.date = date;
        this.total = total;
    }

    public BillDTO(String id, float total) {
        this.id = id;
        this.total = total;
    }
    
    public Vector toVector(){
        Vector result = new Vector();
        result.add(id);
        result.add(total);
        return result;
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
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
