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

        output.append("----------------------\n");
        output.append("税额：").append(totalSalesTax)
                .append("\n");
        if(order.getWeekDay().equals(DayOfWeek.WEDNESDAY)){
            double discount = getDiscount(totalAmount);
            output.append("折扣：").append(discount);
            totalAmount = BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(discount)).doubleValue();
        }


        output.append("\n");
        output.append("总价：").append(totalAmount);
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
                + orderItem.totalAmount() + '\n';
    }

    private String getHeaders() {
        return "===== 老王超市，值得信赖 =====\n" + order.getDate() + "\n";
    }
}