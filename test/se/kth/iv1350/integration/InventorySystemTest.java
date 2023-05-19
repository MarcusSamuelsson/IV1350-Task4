package test.se.kth.iv1350.integration;

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
        Item result = inventorySystem.getItemWithID(0, 2);
        assertNotNull(result);
    }

    @Test
    void getNotExistingItem() throws InvalidItemIdentifierException, DatabaseUnreachableException {
        Item result = inventorySystem.getItemWithID(7, 2);
        assertNull(result);
    }
}
