package main.se.kth.iv1350.view;

import java.io.FileWriter;
import java.io.PrintWriter;

import main.se.kth.iv1350.model.SaleObserver;

public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue;
    private PrintWriter printStream;

    /**
     * Constructor inizilasing the file in which to write the information to.
     */
    public TotalRevenueFileOutput() {
        try {
            printStream = new PrintWriter(new FileWriter("totalRevenue.txt"), true);
        } catch (Exception e) {
            System.out.println("Could not log!");
            e.printStackTrace();
        }
    }
    

    /**
     * Adds the current sale to the total revenue and prints to file the updated totalRevenue.
     * 
     * @param amount current sales total cost.
     */
    @Override
    public void completedSale(double amount) {
        totalRevenue += amount;
        printStream.println("Total revenue: " + totalRevenue);
    }
}
