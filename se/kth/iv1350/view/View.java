package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;

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
        controller.startSale();
    }

    /**
     * Finds scanned item using id
     * 
     * @param id is the identification number for the product
     * @param quantity the quantity of the scanned product
     */
    public void scanItem(int itemID, int quantity) {
        controller.getItemWithID(itemID, quantity);
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
        controller.pay(amount);
    }
}
