/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.category;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class CategoryDTO implements Serializable{
    private String id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(String ID, String name) {
        this.id = ID;
        this.name = name;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return id;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.id = ID;
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
    
    
}
