package main.se.kth.iv1350.integration;

public class DiscountDB {
    
    /**
     * Checks if the customer i eligable fot a discount and returns the discount in 0-100%
     * 
     * @param customerID the identification number of the current customer
     */
    public int checkForDiscount(int customerID) {
        if(customerID%2 == 0)
            return 20;

        return 0;
    }
}
