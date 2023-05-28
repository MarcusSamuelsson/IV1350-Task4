package main.se.kth.iv1350.integration;

public class DatabaseUnreachableException extends Exception {
    /**
     * Thrown when an something causes the database to be offline in <code>InventorySystem</code>.
     * @param message is used for storing the exception message that is logged.
     */
    public DatabaseUnreachableException(String message){
        super(message);
    }
}
