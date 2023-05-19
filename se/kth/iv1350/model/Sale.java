package se.kth.iv1350.model;

import se.kth.iv1350.integration.Item;

public class Sale {
    SaleInfo saleInfo;
    Payment payment;

    public Sale() {
        saleInfo = new SaleInfo(null, null);
        payment = new Payment();
    }

    /** 
     * Adds ant item to the salesinfo for information on the product and gives payment infor of the item to payment.
     * 
     * @param item object holding infomation of the object in the being scanned
    */
    public void addItem(Item item) {
        saleInfo.addItem(item);
        payment.addItem(item);
    }

    /**
     * Calls the function in payment that applies the discount
     * 
     * @param discount the discount in 0-100%
     */
    public void applyDiscount(int discount) {
        payment.applyDiscount(discount);
    }

    /**
     * Calls the function in payment that resolves the payment
     * 
     * @param amount the payed amount by the customer
     */
    public void pay(double amount) {
        payment.pay(amount);
    }

    /**
     * Gets the saleInfo variable
     * 
     * @return saleInfo
     */
    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    /**
     * Gets the payment variable
     * 
     * @return payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Converts the Sale to an easily readable string
     */
    public String toString() {        
        return saleInfo.toString() + "\n\n" + payment.toString();
    }
}
