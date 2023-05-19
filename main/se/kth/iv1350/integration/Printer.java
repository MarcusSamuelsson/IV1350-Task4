package main.se.kth.iv1350.integration;

import main.se.kth.iv1350.model.Sale;
import main.se.kth.iv1350.model.SaleInfo;

public class Printer {
    SaleInfo reciept;

    /**
     * Print the reciept
     * 
     * @param sale the current sale with all the relevant information
     */
    public void print(Sale sale) {
        System.out.println(sale.toString());
    }
}
