package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<OrderItem> orderItemList;

    public Order(String customerName, String address, List<OrderItem> orderItemList) {
        this.customerName = customerName;
        this.address = address;
        this.orderItemList = orderItemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<OrderItem> getLineItems() {
        return orderItemList;
    }
}
