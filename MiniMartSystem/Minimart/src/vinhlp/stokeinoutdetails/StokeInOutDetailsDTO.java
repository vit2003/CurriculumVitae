/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.stokeinoutdetails;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class StokeInOutDetailsDTO implements Serializable{
    
    private String id, stokeInOutId, productID;
    private int amount;

    public StokeInOutDetailsDTO() {
    }

    public StokeInOutDetailsDTO(String id, String stokeInOutId, String productID, int amount) {
        this.id = id;
        this.stokeInOutId = stokeInOutId;
        this.productID = productID;
        this.amount = amount;
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
     * @return the stokeInOutId
     */
    public String getStokeInOutId() {
        return stokeInOutId;
    }

    /**
     * @param stokeInOutId the stokeInOutId to set
     */
    public void setStokeInOutId(String stokeInOutId) {
        this.stokeInOutId = stokeInOutId;
    }

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
