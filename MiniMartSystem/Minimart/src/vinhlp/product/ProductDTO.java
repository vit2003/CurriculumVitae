/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.product;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class ProductDTO implements Serializable{
    
    private String id, name, category, packaging;
    private float uniprice;
    private boolean status;
    private int quan;

    public ProductDTO() {
    }

    public ProductDTO(String id, String name, String category, String packaging, float uniprice, boolean status, int quan) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.packaging = packaging;
        this.uniprice = uniprice;
        this.status = status;
        this.quan = quan;
    }

    public Vector toVector(){
        Vector result = new Vector();
        result.add(id);
        result.add(name);
        result.add(uniprice);
        result.add(packaging);
        result.add(getQuan());
        return result;
    }
    
    public Vector toVector(String id){
        Vector result = new Vector();
        result.add(name);
        result.add(uniprice);
        result.add(category);
        result.add(quan);
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the packaging
     */
    public String getPackaging() {
        return packaging;
    }

    /**
     * @param packaging the packaging to set
     */
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    /**
     * @return the uniprice
     */
    public float getUniprice() {
        return uniprice;
    }

    /**
     * @param uniprice the uniprice to set
     */
    public void setUniprice(float uniprice) {
        this.uniprice = uniprice;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
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
