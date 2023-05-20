package main.se.kth.iv1350.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeAndDate {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
    String timeAndDate;

    /**
     * Constructior for inizilising the TimeAndDate.
     * Formats the information.
     */
    public TimeAndDate() {
        timeAndDate = formatter.format(date);
    }

    /**
     * Gets the timeAndDate variable
     * 
     * @return timeAndDate
     */
    public String getTimeAndDate() {
        return timeAndDate;
    }
}
