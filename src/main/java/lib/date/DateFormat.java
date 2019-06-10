package lib.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    private static final String DATABASE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String BRAZILIAN_FORMAT = "dd/MM/yyyy HH:mm:ss";
    
    public static DateTimeFormatter getDatabaseFormatter() {
        return DateTimeFormatter.ofPattern(DATABASE_FORMAT);
    }
    
    public static DateTimeFormatter getBrazilianFormatter() {
        return DateTimeFormatter.ofPattern(BRAZILIAN_FORMAT);
    }
    
    public static LocalDateTime getDateTimeFromString(String date) {
        return  LocalDateTime.parse(date, getDatabaseFormatter());
    }
}
