package utils;

import org.joda.time.LocalDate;

public class DateUtils {

    public boolean isDateInThePast(LocalDate date1, LocalDate date2) {
        return !date1.isAfter(date2);
    }
}
