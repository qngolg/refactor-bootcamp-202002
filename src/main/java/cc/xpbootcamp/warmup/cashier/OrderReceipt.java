package cc.xpbootcamp.warmup.cashier;

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
        printHeaders(output);

        // prints lineItems
        double totalAmount = 0d;
        for (OrderItem orderItem : order.getLineItems()) {
            printOrderItems(output, orderItem);
            totalAmount += orderItem.totalAmount();
        }

        double totalSalesTax = totalAmount * .10;
        totalAmount += totalSalesTax;
        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmount);
        return output.toString();
    }

    private void printOrderItems(StringBuilder output, OrderItem orderItem) {
        output.append(orderItem.getDescription());
        output.append('\t');
        output.append(orderItem.getPrice());
        output.append('\t');
        output.append(orderItem.getQuantity());
        output.append('\t');
        output.append(orderItem.totalAmount());
        output.append('\n');
    }

    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}