package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateHelper {
    public static String convertDate(String textDate) {
        DateTimeFormatter formatterToDate = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a", Locale.ENGLISH);
        DateTimeFormatter formatterToString = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        LocalDateTime parsedDate = LocalDateTime.parse(textDate, formatterToDate);
        return parsedDate.format(formatterToString);
    }
}
