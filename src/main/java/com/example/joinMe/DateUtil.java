package com.example.joinMe;

import org.hibernate.type.TimestampType;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    final static ZoneId DEFAULT_ZONE = ZoneId.of("Europe/Stockholm");

    private DateUtil() {
    }

    public static ZonedDateTime toModelDate(String dateStr) {
        LocalDateTime ld = LocalDateTime.parse(dateStr, DATE_TIME_FORMATTER);
        ZonedDateTime zd = ZonedDateTime.of(ld, DEFAULT_ZONE);
        return zd;
    }

    public static ZonedDateTime toModelDate(Timestamp ts) {
        return ts.toLocalDateTime().atZone(DEFAULT_ZONE);
    }

    public static Timestamp toDbFormat(ZonedDateTime zt) {
       return  Timestamp.valueOf(zt.toLocalDateTime());
    }


}
