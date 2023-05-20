package main.se.kth.iv1350.view;

import main.se.kth.iv1350.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private double totalRevenue;

    /**
     * Adds the current sale to the total revenue and prints the updated totalRevenue.
     * 
     * @param amount current sales total cost.
     */
    @Override
    public void completedSale(double amount) {
        totalRevenue += amount;
        System.out.println("Total revenue: " + totalRevenue);
    }
}
