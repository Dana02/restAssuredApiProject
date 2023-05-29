package org.example.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAndTimeUtils {

    public static String getLocalDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    public static String getLocalDate(String dateFormat) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return currentDate.format(formatter);
    }

    public static org.joda.time.LocalDate getJodaLocalDate() {
        return new org.joda.time.LocalDate();
    }
}
