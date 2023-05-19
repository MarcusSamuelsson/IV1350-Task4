package se.kth.iv1350.integration;

public class ExternalSystems {
    InventorySystem inventorySystem;
    AccountingSystem accountingSystem;
    DiscountDB discountDB;

    public ExternalSystems() {
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        discountDB = new DiscountDB();
    }

    /**
     * Gets the inventorySystem variable
     * 
     * @return inventorySystem
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }

    /**
     * Gets the accountingSystem variable
     * 
     * @return accountingSystem
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Gets the discountDB variable
     * 
     * @return discountDB
     */
    public DiscountDB getDiscountDB() {
        return discountDB;
    }
}
