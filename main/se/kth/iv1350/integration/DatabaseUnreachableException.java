package main.se.kth.iv1350.integration;

public class DatabaseUnreachableException extends Exception {
    /**
     * This method creates an instance of DataBaseOfflineException
     * @param message is used for storing the exception message that is logged.
     */
    public DatabaseUnreachableException(String message){
        super(message);
    }
}
