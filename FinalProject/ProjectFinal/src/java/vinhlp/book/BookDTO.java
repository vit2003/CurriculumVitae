/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.book;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Asus
 */
public class BookDTO implements Serializable{
    
    private String id;
    private String name;
    private int quantity;
    private String category;
    private float price;

    public BookDTO() {
    }

    public BookDTO(String id, String name, int quantity, String category, float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    public boolean existIn(List<BookDTO> dtos){
        boolean result = false;
        for (BookDTO dto : dtos){
            if(this.id.trim().equalsIgnoreCase(dto.getId().trim())){
                result = true;
                break;
            }
        }
        return result;
    }
    
}
