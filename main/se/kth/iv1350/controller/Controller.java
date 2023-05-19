package main.se.kth.iv1350.controller;

import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.ExternalSystems;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.integration.Item;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.model.Register;
import main.se.kth.iv1350.model.Sale;

public class Controller {
    ExternalSystems externalSystems;
    Register register;
    Printer printer;
    Sale sale;

    /**
     * Constructor to create a new instance of Controller
     * 
     * @param externalSystems the external systems handler 
     * @param register the register
     * @param printer the printer
     */
    public Controller(ExternalSystems externalSystems, Register register, Printer printer) {
        this.externalSystems = externalSystems;
        this.register = register;
        this.printer = printer;
    }

    /**
     * Initiates the sale
     */
    public Sale startSale() {
        sale = new Sale();
        return sale;
    }

    /**
     * Finds scanned item using id
     * 
     * @param id is the identification number for the product
     * @param quantity the quantity of the scanned product
     */
    public String getItemWithID(int id, int quantity) throws InvalidItemIdentifierException, DatabaseUnreachableException {
        Item item = externalSystems.getInventorySystem().getItemWithID(id, quantity);
        
        if(item != null){
            return "\n\n" + sale.addItem(item) + "\n\n";
        }

        return "Item does not exists!\nRunning total: " + sale.getPayment().getTotalAmount();
    }

    /**
     * Checks if the customer i eligable for a discount and applies it
     * 
     * @param customerID is the identification number for the current customer
     */
    public void checkForDiscount(int customerID) {
        int discount = externalSystems.getDiscountDB().checkForDiscount(customerID);

        if(discount > 0)
            sale.applyDiscount(discount);
    }

    /**
     * Resolves all the parts of the payment
     * 
     * @param amount the amount payed by the customer
     */
    public String pay(double amount) {
        String paymentStatus = sale.pay(amount);

        register.addPayment(amount);
        externalSystems.getInventorySystem().updateInventory(sale.getSaleInfo());
        externalSystems.getAccountingSystem().updateAccounting(sale.getPayment());
        printer.print(sale);
        return paymentStatus;
    }
}
