package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private LocalDate date;
    private List<OrderItem> orderItemList;

    public Order(LocalDate date, List<OrderItem> orderItemList) {
        this.date = date;
        this.orderItemList = orderItemList;
    }

    public List<OrderItem> getLineItems() {
        return orderItemList;
    }

    public String getDate() {
        return this.date.getYear() + "年" + this.date.getMonth().getValue() + "月" + this.date.getDayOfMonth() + "日" + "，" + this.getChineseWeekDay();
    }

    private DayOfWeek getWeekDay() {
        return this.date.getDayOfWeek();
    }

    private String getChineseWeekDay(){
        return WeekDayForChinese.from(getWeekDay());
    }
}
