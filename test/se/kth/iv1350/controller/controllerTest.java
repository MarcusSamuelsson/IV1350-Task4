package test.se.kth.iv1350.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.ExternalSystems;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.model.Register;
import main.se.kth.iv1350.model.Sale;
import main.se.kth.iv1350.model.SaleObserver;
import main.se.kth.iv1350.view.TotalRevenueFileOutput;
import main.se.kth.iv1350.view.TotalRevenueView;
import main.se.kth.iv1350.controller.Controller;

public class controllerTest {
    ExternalSystems externalSystems = new ExternalSystems();
    Register register = new Register();
    Printer printer = new Printer();
    Sale sale;
    Controller controller;
    SaleObserver[] sObs = {new TotalRevenueFileOutput(), new TotalRevenueView()};

    @BeforeEach
    void setupForTest() {
        controller = new Controller(externalSystems, register, printer);
        sale = controller.startSale(sObs);
    }

    @Test
    void startSaleTest() {
        assertNotNull(sale);
    }

    @Test
    void addItemTest() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        controller.getItemWithID(0, 2);
        int result = sale.getSaleInfo().numberOfItemsInCart();
        assertEquals(1, result);
    }

    @Test
    void payTest() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        sale.addItem(externalSystems.getInventorySystem().getItemWithID(0, 2));
        String paymentStatus = controller.pay(31.8);
        assertEquals("Successful payment! Total change: 0.0$", paymentStatus);
    }

    @Test
    void applyDiscountTest() {
        controller.checkForDiscount(40);
        double result = sale.getPayment().getDiscount();
        assertEquals(0.2, result);
    }
}
