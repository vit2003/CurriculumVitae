/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class CartObject implements Serializable {

    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String title) {
        //1. check existed of items
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        //2. check existed of product
        int quantity = 1;
        if (this.items.containsKey(title)) {
            quantity = this.items.get(title) + 1;
        }

        this.items.put(title, quantity);
    }
    
    public void deleteItems(String title){
        this.items.remove(title);
    }
}
