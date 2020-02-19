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

    public BigDecimal getAmount(){
        return getLineItems()
                .stream()
                .map(OrderItem::totalAmount)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public BigDecimal getSalesTax() {
        return getAmount().multiply(BigDecimal.valueOf(.10));
    }

    public BigDecimal getDiscount(){
        return getTotalWithNoDiscount()
                .multiply(BigDecimal.valueOf(.02))
                .setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getTotal(){
        if(getWeekDay().equals(DayOfWeek.WEDNESDAY)){
            return getTotalWithDiscount();
        }
        return getTotalWithNoDiscount();
    }

    private BigDecimal getTotalWithNoDiscount() {
        return getAmount().add(getSalesTax());
    }

    private BigDecimal getTotalWithDiscount() {
        return getAmount().add(getSalesTax())
                .subtract(getDiscount());
    }
}
