package main.se.kth.iv1350.model;

import main.se.kth.iv1350.DTO.ItemDescriptionDTO;
import main.se.kth.iv1350.integration.Item;

public class Sale {
    final SaleInfo saleInfo;
    final Payment payment;
    final SaleObserver[] sObs;

    public Sale(SaleObserver[] sObs) {
        saleInfo = new SaleInfo();
        payment = new Payment();
        this.sObs = sObs;
    }

    /** 
     * Adds ant item to the salesinfo for information on the product and gives payment infor of the item to payment.
     * 
     * @param item object holding infomation of the object in the being scanned
     * 
     * @return the current item description and the current total cost.
    */
    public String addItem(Item item) {
        ItemDescriptionDTO currItem = saleInfo.addItem(item);
        payment.addItem(item);
        
        return "Item description:\n" + currItem.getName() + "\n" + currItem.getPrice() + "\nVAT: " + currItem.getVAT() + "\nWeight: " +
        currItem.getWeight() + "g\n\nRunning total: " + payment.getTotalAmount();
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
    public String pay(double amount) {
        double change = payment.pay(amount);

        notifyObserver();

        if(change < 0)
            return (change*-1.0) + "$ missing from payment";
        else
            return "Successful payment! Total change: " + change + "$";
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
     * Updates the total sale revenue
     */
    private void notifyObserver() {
        sObs[0].completedSale(payment.getTotalAmount());
        sObs[1].completedSale(payment.getTotalAmount());
    }

    /**
     * Converts the Sale to an easily readable string
     */
    public String toString() {        
        return saleInfo.toString() + "\n\n" + payment.toString();
    }
}
