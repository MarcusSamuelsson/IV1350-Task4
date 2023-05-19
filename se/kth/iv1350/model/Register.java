package se.kth.iv1350.model;
public class Register {
    double totalAmount;

    /**
     * Adds the current payment to the register
     * 
     * @param amount the payed amount by the customer
     */
    public void addPayment(double amount) {
        totalAmount += amount;
    }
}
