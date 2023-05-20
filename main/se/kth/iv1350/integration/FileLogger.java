package main.se.kth.iv1350.integration;

import java.io.FileWriter;
import java.io.PrintWriter;

import main.se.kth.iv1350.model.TimeAndDate;

public class FileLogger implements Logger {
    private PrintWriter logStream;

    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (Exception e) {
            System.out.println("Could not log!");
            e.printStackTrace();
        }
    }

    /**
     * Prints specified string to a log file.
     * 
     * @param msg the string to be printed.
     */
    @Override
    public void log(String msg) {
        String currTime = new TimeAndDate().getTimeAndDate();
        logStream.println(currTime + ": " + msg + "\n");
    }
}
