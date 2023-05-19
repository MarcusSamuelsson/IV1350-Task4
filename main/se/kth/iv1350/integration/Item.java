package main.se.kth.iv1350.integration;

import main.se.kth.iv1350.DTO.ItemDescriptionDTO;

public class Item {
    ItemDescriptionDTO itemDesc;
    int quantity;

    Item(ItemDescriptionDTO itemDesc, int quantity) {
        this.itemDesc = itemDesc;
        this.quantity = quantity;
    }

    /**
     * Increases the quantity of the current Item
     * 
     * @param quantity is the number to be added to the quantity
     * @return the current quantity after adding the new
     */
    public int increaseQuantity(int quantity) {
        this.quantity += quantity;

        return this.quantity;
    }

    /**
     * Gets the quantity variable
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the itemDesc variable
     * 
     * @return itemDesc
     */
    public ItemDescriptionDTO getItemDesc() {
        return itemDesc;
    }

    public String toString() {        
        return itemDesc.getName() + "  Quantity: " + quantity + "  Price: "
        + itemDesc.getPrice() + "$" + "  VAT: " + itemDesc.getVAT() + "%";
    }
}
