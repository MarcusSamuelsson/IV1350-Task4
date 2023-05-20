package test.se.kth.iv1350.integration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.se.kth.iv1350.integration.DatabaseUnreachableException;
import main.se.kth.iv1350.integration.InvalidItemIdentifierException;
import main.se.kth.iv1350.integration.InventorySystem;
import main.se.kth.iv1350.integration.Item;

public class InventorySystemTest {
    InventorySystem inventorySystem = new InventorySystem();

    @Test
    void getExistingItem() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        try {
            Item result = inventorySystem.getItemWithID(0, 2);
            assertNotNull(result);
        } catch (InvalidItemIdentifierException e) {
            fail("Valid id was flagged as invalid!");
        }
    }

    @Test
    void getNotExistingItem() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        try {
            Item result = inventorySystem.getItemWithID(7, 2);
            fail("Could find invalid id!");
        } catch (InvalidItemIdentifierException e) {
            assertTrue("Wrong exception message, does not " +
            "contain specified id: " + e.getMessage(),
            e.getMessage().contains("7"));
        }
    }

    @Test
    void databaseOffline() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        try {
            Item result = inventorySystem.getItemWithID(5, 2);
            fail("Database is reach even though it is offline!");
        } catch (DatabaseUnreachableException e) {
            assertTrue("Wrong exception message, does not " +
            "contain correct information: " + e.getMessage(),
            e.getMessage().contains("Database cannot be reached"));
        }
    }

    @Test
    void databaseOnline() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        try {
            Item result = inventorySystem.getItemWithID(4, 2);
            assertNotNull(result);
        } catch (DatabaseUnreachableException e) {
            fail("Database is offline but should be online!");
        }
    }
}
