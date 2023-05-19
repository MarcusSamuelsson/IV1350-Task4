package test.se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.se.kth.iv1350.integration.ExternalSystems;
import main.se.kth.iv1350.integration.Item;

public class ItemTest {
    ExternalSystems externalSystems = new ExternalSystems();
    Item item;

    @BeforeEach
    void setupForTest() {
        item = externalSystems.getInventorySystem().getItemWithID(0, 2);
    }

    @Test
    void increaseQuantityTest() {
        int result = item.increaseQuantity(2);
        assertEquals(4, result);
    }
}
