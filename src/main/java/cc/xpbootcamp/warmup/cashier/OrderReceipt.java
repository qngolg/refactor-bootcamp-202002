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
        double totSalesTx = 0d;
        double tot = 0d;
        for (OrderItem orderItem : order.getLineItems()) {
            printOrderItems(output, orderItem);

            // calculate sales tax @ rate of 10%
            double salesTax = orderItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of orderItem = price * quantity + 10 % sales tax
            tot += orderItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        output.append("Total Amount").append('\t').append(tot);
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