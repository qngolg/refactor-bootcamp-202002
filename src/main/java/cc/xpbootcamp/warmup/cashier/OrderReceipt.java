package cc.xpbootcamp.warmup.cashier;

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

        // print headers
        output.append(getHeaders());

        // prints lineItems
        output.append(getOrderItemsDetail());

        double totalAmount = getTotalAmount();
        double totalSalesTax = totalAmount * .10;
        totalAmount += totalSalesTax;
        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmount);
        return output.toString();
    }

    private double getTotalAmount() {
        return order.getLineItems().stream().map(OrderItem::totalAmount).count();
    }

    private String getOrderItemsDetail() {
        return order.getLineItems().stream()
                .map(this::getOrderItemDetail)
                .collect(Collectors.joining(""));
    }

    private String getOrderItemDetail(OrderItem orderItem) {
        return orderItem.getDescription() + '\t'
                + orderItem.getPrice() + '\t'
                + orderItem.getQuantity() + '\t'
                + orderItem.totalAmount() + '\n';
    }

    private String getHeaders() {
        return "===== 老王超市，值得信赖 =====\n" + order.getDate() + "\n";
    }
}