package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.util.stream.Stream;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

public enum  WeekDayForChinese {
    Monday(MONDAY,"星期一"),
    TuesDay(TUESDAY,"星期二"),
    Wednesday(WEDNESDAY,"星期三"),
    Thursday(THURSDAY,"星期四"),
    Friday(FRIDAY,"星期五"),
    Saturday(SATURDAY,"星期六"),
    Sunday(SUNDAY,"星期日");

    private DayOfWeek day;
    private String value;

    WeekDayForChinese(DayOfWeek dayOfWeek, String value) {
        this.day = dayOfWeek;
        this.value = value;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public String getValue() {
        return value;
    }

    public static String from(DayOfWeek weekDay) {
        return Stream.of(WeekDayForChinese.values())
                .filter(weekDayForChinese -> weekDayForChinese.getDay().equals(weekDay))
                .findFirst()
                .map(WeekDayForChinese::getValue)
                .get();

    }
}
