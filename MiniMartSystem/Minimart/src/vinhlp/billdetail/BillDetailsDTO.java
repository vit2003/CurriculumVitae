/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.billdetail;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class BillDetailsDTO implements Serializable{
    
    private String id, billId, productId;
    private int amount;

    public BillDetailsDTO() {
    }

    public BillDetailsDTO(String id, String billId, String productId, int amount) {
        this.id = id;
        this.billId = billId;
        this.productId = productId;
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
     * @return the billId
     */
    public String getBillId() {
        return billId;
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(String billId) {
        this.billId = billId;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
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
