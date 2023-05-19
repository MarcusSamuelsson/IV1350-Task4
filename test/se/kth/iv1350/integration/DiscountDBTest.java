package test.se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.se.kth.iv1350.integration.DiscountDB;

public class DiscountDBTest {
    DiscountDB discountDB = new DiscountDB();

    @Test
    void isEligableForDiscount() {
        int result = discountDB.checkForDiscount(0);
        assertEquals(20, result);
    }
    
    @Test
    void isNotEligableForDiscount() {
        int result = discountDB.checkForDiscount(1);
        assertEquals(0, result);
    }
}
