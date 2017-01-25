package com.chmykhun.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String DD_MM_YYYY = "dd.MM.yyyy";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static LocalDate stringToLocalDate(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    public static String localDateToString(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static String dateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static LocalDate dateToLocalDate(Date date) {
        return date.toLocalDate();
    }

}
