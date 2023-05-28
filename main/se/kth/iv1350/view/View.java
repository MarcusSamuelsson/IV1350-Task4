package main.se.kth.iv1350.view;

import java.util.Random;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.model.SaleObserver;

public class View {
    Controller controller;
    SaleObserver[] sObs = {new TotalRevenueFileOutput(), new TotalRevenueView()};

    /**
     * Constructor to create a new instance of View
     * 
     * @param contr the controller
     */
    public View(Controller contr) {
        this.controller = contr;
    }

    /**
     * Runs through a simulation of the program
     * 
     * @throws InvalidItemIdentifierException if the item id does not correspond to an existing item.
     * 
     * @throws DatabaseUnreachableException if the Inventory system server is not possible to reach.
     */
    public void runSimulation() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        Random rand = new Random();

        for(int i = 0; i < 4; i++) {
            System.out.println("Sale started:\n" + controller.startSale(sObs).toString() + "\n");

            try {
                System.out.println(controller.getItemWithID(rand.nextInt(5), 1));
                System.out.println(controller.getItemWithID(rand.nextInt(5), 1));
                System.out.println(controller.getItemWithID(rand.nextInt(5), 1));
                System.out.println(controller.getItemWithID(rand.nextInt(5), 1));
                System.out.println(controller.getItemWithID(rand.nextInt(5), 5));
                System.out.println(controller.getItemWithID(rand.nextInt(5), 5));
                System.out.println(controller.getItemWithID(rand.nextInt(5), 2));
                //System.out.println(controller.getItemWithID(5, 2));
                //System.out.println(controller.getItemWithID(6, 2));
            } catch (InvalidItemIdentifierException e) {
                System.err.println(e.getMessage());
            } catch (DatabaseUnreachableException e) {
                System.err.println(e.getMessage());
            }
        
            controller.checkForDiscount(rand.nextInt(2));

            System.out.println(controller.pay(800));
        }
    }
}
