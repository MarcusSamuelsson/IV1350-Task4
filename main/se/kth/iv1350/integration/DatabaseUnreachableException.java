package main.se.kth.iv1350.integration;

public class DatabaseUnreachableException extends Exception {
    Logger logger = new FileLogger();

    /**
     * This method creates an instance of DataBaseOfflineException
     * @param message is used for storing the exception message that is logged.
     */
    public DatabaseUnreachableException(String message){
        super(message);
        logger.log(message);
    }
}
