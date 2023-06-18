package helpers;

import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateHelper {
    @Step("Конвертирование даты в строке")
    public static String convertDate(String textDate) {
        DateTimeFormatter formatterToDate = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a", Locale.ENGLISH);
        DateTimeFormatter formatterToString = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        LocalDateTime parsedDate = LocalDateTime.parse(textDate, formatterToDate);
        return parsedDate.format(formatterToString);
    }

    @Step("Получение текущего дня месяца")
    public static int getCurrentDayNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        LocalDate date = LocalDate.now();
        return Integer.parseInt(date.format(formatter));
    }
}
