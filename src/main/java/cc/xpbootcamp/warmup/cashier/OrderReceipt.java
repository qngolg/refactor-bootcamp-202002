package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private static final String NEWLINE = "\n";
    private static final String TITLE = "===== 老王超市，值得信赖 =====";
    private static final String SEPARATED_LINE = "----------------------";
    private static final String SALES_TAX_HEADER = "税额：";
    private static final String DISCOUNT_HEADER = "折扣：";
    private static final String TOTAL_AMOUNT_HEADER = "总价：";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(printHeaders()).append(NEWLINE);

        output.append(printOrderItems());

        output.append(SEPARATED_LINE).append(NEWLINE);
        output.append(SALES_TAX_HEADER).append(format(order.getSalesTax())).append(NEWLINE);

        if (order.hasDiscount()) {
            output.append(DISCOUNT_HEADER).append(format(order.getDiscount()));
        }

        output.append(NEWLINE);
        output.append(TOTAL_AMOUNT_HEADER).append(format(order.getTotal()));
        return output.toString();
    }

    private String format(BigDecimal decimal) {
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(decimal);
    }

    private String printOrderItems() {
        return order.getLineItems().stream()
                .map(this::printOrderItem)
                .collect(Collectors.joining(NEWLINE));
    }

    private String printOrderItem(OrderItem orderItem) {
        return orderItem.getDescription() + '，'
                +format(orderItem.getPrice()) + " × "
                + orderItem.getQuantity() + '，'
                + format(orderItem.totalAmount());
    }

    private String printHeaders() {
        return TITLE + NEWLINE + printDate() + NEWLINE;
    }

    private String printDate() {
        return order.getDate().getYear() + "年"
                + order.getDate().getMonth().getValue() + "月"
                + order.getDate().getDayOfMonth() + "日" + "，"
                + getChineseWeekDay();
    }

    private String getChineseWeekDay() {
        return WeekDayForChinese.from(order.getWeekDay());
    }
}