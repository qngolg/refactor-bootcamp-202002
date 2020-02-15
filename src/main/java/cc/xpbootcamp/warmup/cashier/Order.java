package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String addr;
    List<OrderItem> orderItemList;

    public Order(String customerName, String addr, List<OrderItem> orderItemList) {
        this.customerName = customerName;
        this.addr = addr;
        this.orderItemList = orderItemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<OrderItem> getLineItems() {
        return orderItemList;
    }
}
