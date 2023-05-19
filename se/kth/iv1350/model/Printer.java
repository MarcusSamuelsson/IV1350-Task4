package se.kth.iv1350.model;
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
