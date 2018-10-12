package cn.like.study.java8.util;

import java.time.*;

/**
 * @program: MyCode
 * @description: Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。
 * @author: like
 * @create: 2018-05-05 16:55
 **/
public class DateTimeAPI {
    public static void main(String[] args) {
        //Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());        //2018-05-05T08:59:14.203Z
        System.out.println(clock.millis());         //1525510754317

        //LocaleDate只持有ISO-8601格式且无时区信息的日期部分
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);

        //LocaleTime只持有ISO-8601格式且无时区信息的时间部分
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);

        //LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式无时区信息的日期与时间
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);
        System.out.println(datetime);
        System.out.println(datetimeFromClock);

        //如果需要特定时区的日期/时间，name选择ZonedDateTime。它持有ISO-8601格式具具有时区信息的日期与时间
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);

        //Duration使计算两个日期间的不同变的十分简单
        final LocalDateTime from = LocalDateTime.of(2018, Month.JANUARY, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2018, Month.APRIL, 16, 23, 59, 59);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
    }
}
