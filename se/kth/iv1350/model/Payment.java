package se.kth.iv1350.model;

import java.text.DecimalFormat;

import se.kth.iv1350.integration.Item;

public class Payment {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    double totalAmount;
    double change;
    double discount;
    
    void addItem(Item item) {
        double price = item.getItemDesc().getPrice();
        int quantity = item.getQuantity();

        totalAmount += price*quantity;
    }

    void applyDiscount(int discount) {
        this.discount = ((double)discount)/100.0;
        totalAmount *= (1.0-this.discount);
    }
    
    double pay(double amount) {
        change = (amount - totalAmount);
        return change;
    }

    /**
     * Converts the Payment to an easily readable string
     */
    public String toString() {
        return "Total cost(With discount): " + df.format(totalAmount) + 
        "$\nTotal cost(Without discount): " + df.format(totalAmount/(1-discount)) + "$\nTotal discount: " 
        + df.format(discount*100) + "%\nChange: " + df.format(change) + "$";
    }
}
