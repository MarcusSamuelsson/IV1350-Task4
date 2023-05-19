package main.se.kth.iv1350.integration;

import main.se.kth.iv1350.DTO.ItemDescriptionDTO;
import main.se.kth.iv1350.model.SaleInfo;

public class InventorySystem {
    ItemDescriptionDTO[] items = new ItemDescriptionDTO[6];

     /**
     * Constructor for InventorySystem that set some items in the system
     */
    public InventorySystem() {
        items[0] = new ItemDescriptionDTO(0, "Milk", 15.9, 1.0, 25);
        items[1] = new ItemDescriptionDTO(1,"Eggs", 45.9, 1.0, 25);
        items[2] = new ItemDescriptionDTO(2, "Cola", 26.5, 1.0, 25);
        items[3] = new ItemDescriptionDTO(3, "Monster", 20.9, 1.0, 25);
        items[4] = new ItemDescriptionDTO(4, "Apple", 10.0, 1.0, 25);
    }
    
    /**
     * Finds scanned item using id
     * If item identifier is 5 a DatabaseUnreachableException is thrown.
     * If the id is out of bounds the InvalidItemIdentifierException is thrown.
     * 
     * @param id is the identification number for the product
     * @param quantity the quantity of the scanned product
     * 
     * @return a new item with the from the id and the quantity or returns null if id is out of bounds
     */
    public Item getItemWithID(int id, int quantity) throws InvalidItemIdentifierException, DatabaseUnreachableException {
        if(id == 5)
            throw new DatabaseUnreachableException("Database cannot be reached!");

        if(id >= items.length)
            throw new InvalidItemIdentifierException("Identifier " + id + "is not a valid id");
            
        
        return new Item(items[id], quantity);
    }

    public void updateInventory(SaleInfo saleInfo) {
        System.out.println("Inventory system added saleInfo:\n" + saleInfo.toString() + "\n");
    }
}
