/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vinhlp.book.BookDTO;

/**
 *
 * @author Asus
 */
public class CartObject implements Serializable {

    Map<BookDTO, Integer> item = null;

    public CartObject() {
    }

    public Map<BookDTO, Integer> getItem() {
        return item;
    }

    public void addItemToCart(String item, List<BookDTO> list) {
        
        if (this.item == null) {
            this.item = new HashMap<>();
        }
        
        BookDTO currentBook = null;
        for (BookDTO dto : list){
            if (dto.getName().trim().equals(item.trim())){
                currentBook = dto;
            }
        }
        
        int quantity = 0;
        if(this.item.containsKey(currentBook)){
            quantity = this.item.get(currentBook);
        }
        this.item.put(currentBook, ++quantity);
    }

    public void deleteItem(String item) {
        BookDTO deleteBook = null;
        for (BookDTO dto : this.item.keySet()){
            if(dto.getName().trim().equalsIgnoreCase(item.trim())){
                deleteBook = dto;
                break;
            }
        }
        this.item.remove(deleteBook);
        if(this.item.isEmpty()){
            this.item = null;
        }
    }
    
    public float getTotal(){
        float result = 0;
        for(BookDTO dto : this.item.keySet()){
            result += dto.getPrice()*this.item.get(dto);
        }
        return result;
    }
}
