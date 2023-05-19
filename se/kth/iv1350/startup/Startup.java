package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.ExternalSystems;
import se.kth.iv1350.model.Printer;
import se.kth.iv1350.model.Register;
import se.kth.iv1350.view.View;

public class Startup {
    /**
     * The main method. Instantiates multiple objects and runs the program with calls to view
     * @param args potential arguments given when executing the program
     */
    public static void main(String[] args) {
        ExternalSystems extSys = new ExternalSystems();
        Register reg = new Register();
        Printer prntr = new Printer();
        Controller contr = new Controller(extSys, reg, prntr);
        View view = new View(contr);
        view.startSale();
        view.scanItem(0, 1);
        view.scanItem(2, 1);
        view.scanItem(3, 1);
        view.scanItem(0, 1);
        view.scanItem(1, 5);
        view.scanItem(4, 2);
        view.checkAndApplyDiscount(0);
        view.pay(300);
    }
}
