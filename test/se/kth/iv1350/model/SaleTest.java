package test.se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.ExternalSystems;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.integration.Item;
import main.se.kth.iv1350.model.Sale;
import main.se.kth.iv1350.model.SaleObserver;
import main.se.kth.iv1350.view.TotalRevenueFileOutput;
import main.se.kth.iv1350.view.TotalRevenueView;

public class SaleTest {
    private Sale sale;
    private Item item;
    private ExternalSystems externalSystems;
    private SaleObserver[] sObs = {new TotalRevenueFileOutput(), new TotalRevenueView()};

    @BeforeEach
    void setupForTest() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        sale = new Sale(sObs);
        externalSystems = new ExternalSystems();
        item = externalSystems.getInventorySystem().getItemWithID(0, 2);
        sale.addItem(item);
    }

    @Test
    void insufficiantPayTest() {
        String paymentStatus = sale.pay(0);
        assertEquals("31.8$ missing from payment", paymentStatus);
    }

    @Test
    void exactPayTest() {
        String paymentStatus = sale.pay(31.8);
        assertEquals("Successful payment! Total change: 0.0$", paymentStatus);
    }

    @Test
    void addItemTest() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        sale.addItem(externalSystems.getInventorySystem().getItemWithID(1, 4));
        int result = sale.getSaleInfo().numberOfItemsInCart();
        assertEquals(2, result);
    }

    @Test
    void addExistingItemTest() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        sale.addItem(externalSystems.getInventorySystem().getItemWithID(0, 4));
        int result = sale.getSaleInfo().numberOfItemsInCart();
        assertEquals(1, result);
    }

    @Test
    void applyDiscountTest() {
        sale.applyDiscount(40);
        double result = sale.getPayment().getDiscount();
        assertEquals(0.4, result);
    }
}
