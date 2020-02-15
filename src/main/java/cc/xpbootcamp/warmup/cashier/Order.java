package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String cName;
    String addr;
    List<OrderItem> orderItemList;

    public Order(String cName, String addr, List<OrderItem> orderItemList) {
        this.cName = cName;
        this.addr = addr;
        this.orderItemList = orderItemList;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<OrderItem> getLineItems() {
        return orderItemList;
    }
}
