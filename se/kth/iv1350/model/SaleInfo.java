package se.kth.iv1350.model;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;

import se.kth.iv1350.integration.Item;

public class SaleInfo {
    Time time;
    Date date;
    HashMap<Integer,Item> items = new HashMap<Integer, Item>();

    SaleInfo(Time time, Date date) {
        this.time = time;
        this.date = date;
    }

    void addItem(Item item) {
        int currID = item.getItemDesc().getId();
        
        if(items.get(currID) == null)
            items.put(currID, item);
        else
            items.get(currID).increaseQuantity(item.getQuantity());
    }

    /**
     * Converts the SaleInfo to an easily readable string
     */
    public String toString() {
        //String finalString = date.toString() + " " + time.toString() +"\nProducts:";
        String finalString = "\nProducts | Quantity | Cost | VAT";

        for (int i = 0; i < items.size(); i++) {
            finalString += "\n" + items.get(i).toString();
        }

        return finalString;
    }
}
