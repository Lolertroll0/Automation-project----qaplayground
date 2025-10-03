package resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {

    public static String getCurrentTime () {
    // Get the current date and time
    LocalDateTime now = LocalDateTime.now();

    // Define the format
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    // Format the current date and time
    return now.format(formatter);
    }
}
