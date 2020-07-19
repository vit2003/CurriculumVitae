/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.stokeinout;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class StokeInOutDTO implements Serializable{
    
    private String id, userID, lastDate, inOrOut;

    public StokeInOutDTO() {
    }

    public StokeInOutDTO(String id, String userID, String lastDate, String inOrOut) {
        this.id = id;
        this.userID = userID;
        this.lastDate = lastDate;
        this.inOrOut = inOrOut;
    }

    public StokeInOutDTO(String id, String inOrOut) {
        this.id = id;
        this.inOrOut = inOrOut;
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
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the lastDate
     */
    public String getLastDate() {
        return lastDate;
    }

    /**
     * @param lastDate the lastDate to set
     */
    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    /**
     * @return the inOrOut
     */
    public String getInOrOut() {
        return inOrOut;
    }

    /**
     * @param inOrOut the inOrOut to set
     */
    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }
    
    public Vector toVector(){
        Vector result = new Vector();
        result.add(id);
        result.add(this.inOrOut);
        return result;
    }
    
}
