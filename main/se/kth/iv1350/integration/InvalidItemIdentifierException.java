package main.se.kth.iv1350.integration;

public class InvalidItemIdentifierException extends Exception {
    Logger logger = new FileLogger();

    /**
     * Thrown when an invalid ID is given to the <code>InventorySystem</code>.
     * @param message is used for storing the exception message that is logged.
     */
    public InvalidItemIdentifierException(String message) {
        super(message);
        logger.log(message);
    }
}
