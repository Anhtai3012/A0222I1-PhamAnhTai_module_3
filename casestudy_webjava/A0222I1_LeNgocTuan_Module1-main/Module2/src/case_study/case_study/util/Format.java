package case_study.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Format {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String getDateFormatter(LocalDate date) {
        return date.format(formatter);
    }
}
