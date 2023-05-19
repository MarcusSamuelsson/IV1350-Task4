package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalSystems;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.model.Register;
import main.se.kth.iv1350.view.View;

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
        view.getItemWithID(0, 1);
        view.getItemWithID(2, 1);
        view.getItemWithID(3, 1);
        view.getItemWithID(0, 1);
        view.getItemWithID(1, 5);
        view.getItemWithID(4, 2);
        view.checkAndApplyDiscount(0);
        view.pay(300);
    }
}
