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

    public LocalDate getDate() {
        return this.date;
    }

    public DayOfWeek getWeekDay() {
        return this.date.getDayOfWeek();
    }

    public BigDecimal getAmount() {
        return getLineItems()
                .stream()
                .map(OrderItem::totalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSalesTax() {
        return getAmount().multiply(BigDecimal.valueOf(.10));
    }

    public BigDecimal getDiscount() {
        return getTotalWithNoDiscount()
                .multiply(BigDecimal.valueOf(.02))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getTotal() {
        if (hasDiscount()) {
            return getTotalWithDiscount();
        }
        return getTotalWithNoDiscount();
    }

    public boolean hasDiscount() {
        return getWeekDay().equals(DayOfWeek.WEDNESDAY);
    }

    private BigDecimal getTotalWithNoDiscount() {
        return getAmount().add(getSalesTax());
    }

    private BigDecimal getTotalWithDiscount() {
        return getAmount().add(getSalesTax())
                .subtract(getDiscount());
    }
}
