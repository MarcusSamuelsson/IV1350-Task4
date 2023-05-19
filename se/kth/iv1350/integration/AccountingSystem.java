package se.kth.iv1350.integration;

import se.kth.iv1350.model.Payment;

public class AccountingSystem {
    /**
     * Updates the accountic system with the current payment
     * 
     * @param payment the current payment
     */
    public void updateAccounting(Payment payment) {
        System.out.println("Accounting system added payment:\n" + payment.toString() + "\n");
    }
}
