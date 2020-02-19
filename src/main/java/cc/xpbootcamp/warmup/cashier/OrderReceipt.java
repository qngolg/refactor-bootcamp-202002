package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
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

        output.append(getHeaders());

        output.append(getOrderItemsDetail());

        double totalAmount = getTotalAmount();
        double totalSalesTax = getTotalSalesTax(totalAmount);
        totalAmount += totalSalesTax;

        output.append(SEPARATED_LINE + NEWLINE);
        output.append(SALES_TAX_HEADER).append(totalSalesTax)
                .append(NEWLINE);
        if(order.getWeekDay().equals(DayOfWeek.WEDNESDAY)){
            double discount = getDiscount(totalAmount);
            output.append(DISCOUNT_HEADER).append(discount);
            totalAmount = BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(discount)).doubleValue();
        }


        output.append(NEWLINE);
        output.append(TOTAL_AMOUNT_HEADER).append(totalAmount);
        return output.toString();
    }

    private double getDiscount(double totalAmount) {
        return BigDecimal.valueOf(totalAmount)
                .multiply(BigDecimal.valueOf(.02))
                .setScale(2,BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }

    private double getTotalSalesTax(double totalAmount) {
        return BigDecimal.valueOf(totalAmount).multiply(BigDecimal.valueOf(.10)).doubleValue();
    }

    private double getTotalAmount() {
        return order.getLineItems().stream().mapToDouble(OrderItem::totalAmount).sum();
    }

    private String getOrderItemsDetail() {
        return order.getLineItems().stream()
                .map(this::getOrderItemDetail)
                .collect(Collectors.joining(""));
    }

    private String getOrderItemDetail(OrderItem orderItem) {
        return orderItem.getDescription() + '，'
                + orderItem.getPrice() + " × "
                + orderItem.getQuantity() + '，'
                + orderItem.totalAmount() + NEWLINE;
    }

    private String getHeaders() {
        return TITLE + NEWLINE + order.getDate() + NEWLINE;
    }
}