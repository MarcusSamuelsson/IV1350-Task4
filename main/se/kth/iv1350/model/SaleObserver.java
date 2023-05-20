package main.se.kth.iv1350.model;

public interface SaleObserver {
    /**
     * @param amount current sales total cost.
     */
    public void completedSale(double amount);
}
