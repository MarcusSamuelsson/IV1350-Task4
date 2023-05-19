package main.se.kth.iv1350.model;

import java.util.HashMap;

import main.se.kth.iv1350.DTO.ItemDescriptionDTO;
import main.se.kth.iv1350.integration.Item;

public class SaleInfo {
    TimeAndDate timeAndDate = new TimeAndDate();
    HashMap<Integer,Item> items = new HashMap<Integer, Item>();

    ItemDescriptionDTO addItem(Item item) {
        int currID = item.getItemDesc().getId();

        Item currItem = items.get(currID);
        
        if(currItem == null){
            items.put(currID, item);
            currItem = items.get(currID);
        } else {
            currItem.increaseQuantity(item.getQuantity());
        }

        return currItem.getItemDesc();
    }

    /**
     * Returns the number of current items
     * @return the size of the items hashmap
     */
    public int numberOfItemsInCart(){
        return items.size();
    }

    /**
     * Converts the SaleInfo to an easily readable string
     */
    public String toString() {
        String finalString = timeAndDate.getTimeAndDate() +"\nProducts | Quantity | Cost | VAT";

        for (int i = 0; i < items.size(); i++) {
            finalString += "\n" + items.get(i).toString();
        }

        return finalString;
    }
}
