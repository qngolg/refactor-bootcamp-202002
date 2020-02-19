package cc.xpbootcamp.warmup.cashier;

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

        output.append(getHeaders()).append(NEWLINE);

        output.append(getOrderItemsDetail());

        output.append(SEPARATED_LINE + NEWLINE);
        output.append(SALES_TAX_HEADER).append(order.getSalesTax()).append(NEWLINE);

        if(order.getWeekDay().equals(DayOfWeek.WEDNESDAY)){
            output.append(DISCOUNT_HEADER).append(order.getDiscount());
        }

        output.append(NEWLINE);
        output.append(TOTAL_AMOUNT_HEADER).append(order.getTotal());
        return output.toString();
    }

    private String getOrderItemsDetail() {
        return order.getLineItems().stream()
                .map(this::getOrderItemDetail)
                .collect(Collectors.joining(NEWLINE));
    }

    private String getOrderItemDetail(OrderItem orderItem) {
        return orderItem.getDescription() + '，'
                + orderItem.getPrice() + " × "
                + orderItem.getQuantity() + '，'
                + orderItem.totalAmount();
    }

    private String getHeaders() {
        return TITLE + NEWLINE + order.getDate() + NEWLINE;
    }
}