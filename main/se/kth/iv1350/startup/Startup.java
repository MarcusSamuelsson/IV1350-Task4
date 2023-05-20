package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.ExternalSystems;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.model.Register;
import main.se.kth.iv1350.view.View;

public class Startup {
    /**
     * The main method. Instantiates multiple objects and runs the program with calls to view
     * @param args potential arguments given when executing the program
     * 
     * @throws InvalidItemIdentifierException if the item id does not correspond to an existing item.
     * 
     * @throws DatabaseUnreachableException if the Inventory system server is not possible to reach.
     */
    public static void main(String[] args) throws InvalidItemIdentifierException, DatabaseUnreachableException {
        ExternalSystems extSys = new ExternalSystems();
        Register reg = new Register();
        Printer prntr = new Printer();
        Controller contr = new Controller(extSys, reg, prntr);
        View view = new View(contr);
        view.runSimulation();
    }
}
