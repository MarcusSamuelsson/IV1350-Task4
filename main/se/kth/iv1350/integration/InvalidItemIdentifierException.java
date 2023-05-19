package main.se.kth.iv1350.integration;

public class InvalidItemIdentifierException extends Exception {
    /**
     * This method creates an instance of ItemIdentifierNotValidException.
     * @param message is used for storing the exception message that is logged.
     */
    public InvalidItemIdentifierException(String message) {
        super(message);
    }
}
