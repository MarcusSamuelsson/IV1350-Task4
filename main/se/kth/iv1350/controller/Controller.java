package main.se.kth.iv1350.controller;

import java.util.logging.Logger;

import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.ExternalSystems;
import main.se.kth.iv1350.integration.FileLogger;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.integration.Item;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.model.Register;
import main.se.kth.iv1350.model.Sale;
import main.se.kth.iv1350.model.SaleObserver;

public class Controller {
    FileLogger logger;
    ExternalSystems externalSystems;
    Register register;
    Printer printer;
    Sale sale;
    SaleObserver[] sObs;

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
        this.logger = new FileLogger();
    }

    /**
     * Initiates the sale
     */
    public Sale startSale(SaleObserver[] sObs) {
        this.sObs = sObs;
        sale = new Sale(sObs);
        return sale;
    }

    /**
     * Finds scanned item using id
     * 
     * @param id is the identification number for the product
     * @param quantity the quantity of the scanned product
     * 
     * @throws InvalidItemIdentifierException if the item id does not correspond to an existing item.
     * 
     * @throws DatabaseUnreachableException if the Inventory system server is not possible to reach.
     */
    public String getItemWithID(int id, int quantity) throws InvalidItemIdentifierException, DatabaseUnreachableException {
        Item item;

        try {
            item = externalSystems.getInventorySystem().getItemWithID(id, quantity);
        } catch (InvalidItemIdentifierException e) {
            logger.log(e.getMessage());
            throw new InvalidItemIdentifierException("Invalid item identifier!");
        } catch (DatabaseUnreachableException e) {
            logger.log(e.getMessage());
            throw new DatabaseUnreachableException("Database could not be reached! Please contact us at: needhelp@bigstore.com");
        }
        
        return "\n\n" + sale.addItem(item) + "\n\n";
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
