package main.se.kth.iv1350.view;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;

public class View {
    Controller controller;

    /**
     * Constructor to create a new instance of View
     * 
     * @param contr the controller
     */
    public View(Controller contr) {
        this.controller = contr;
    }

    /**
     * Call the function to start a sale
     */
    public void startSale() {
        System.out.println("Sale started:\n" + controller.startSale().toString() + "\n");
    }

    /**
     * Finds scanned item using id, prints the items description
     * and the running total.
     * 
     * @param id is the identification number for the product
     * @param quantity the quantity of the scanned product
     */
    public void getItemWithID(int itemID, int quantity) throws InvalidItemIdentifierException, DatabaseUnreachableException {
        System.out.println(controller.getItemWithID(itemID, quantity));
    }

    /**
     * Calls the function in payment that applies the discount
     * 
     * @param discount the discount in 0-100%
     */
    public void checkAndApplyDiscount(int customerID) {
        controller.checkForDiscount(customerID);
    }

    /**
     * Resolves all the parts of the payment
     * 
     * @param amount the amount payed by the customer
     */
    public void pay(int amount) {
        System.out.println(controller.pay(amount));
    }
}
