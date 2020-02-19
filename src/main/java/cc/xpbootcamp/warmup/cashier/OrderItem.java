package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;

public class OrderItem {
	private String name;
	private BigDecimal price;
	private int quantity;

	public OrderItem(String name, BigDecimal price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public static OrderItem of(String name, double price, int quantity){
		return new OrderItem(name, BigDecimal.valueOf(price), quantity);
	}

	public String getDescription() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    BigDecimal totalAmount() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}