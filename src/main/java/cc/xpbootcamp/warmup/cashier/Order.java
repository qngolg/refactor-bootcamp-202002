package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;
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

    public DayOfWeek getWeekDay() {
        return this.date.getDayOfWeek();
    }

    private String getChineseWeekDay(){
        return WeekDayForChinese.from(getWeekDay());
    }

    public double getAmount(){
        return getLineItems().stream().mapToDouble(OrderItem::totalAmount).sum();
    }

    public double getSalesTax() {
        return BigDecimal.valueOf(getAmount()).multiply(BigDecimal.valueOf(.10)).doubleValue();
    }

    public double getDiscount(){
        return BigDecimal.valueOf(getTotalWithNoDiscount())
                .multiply(BigDecimal.valueOf(.02))
                .setScale(2,BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }

    public double getTotal(){
        if(getWeekDay().equals(DayOfWeek.WEDNESDAY)){
            return getTotalWithDiscount();
        }
        return getTotalWithNoDiscount();
    }

    private double getTotalWithNoDiscount() {
        return getAmount() + getSalesTax();
    }

    private double getTotalWithDiscount() {
        return BigDecimal.valueOf(getAmount())
                .add(BigDecimal.valueOf(getSalesTax()))
                .subtract(BigDecimal.valueOf(getDiscount()))
                .doubleValue();
    }
}
