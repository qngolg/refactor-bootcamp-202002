package cc.xpbootcamp.warmup.cashier;

public class OrderItem {
	private String name;
	private double price;
	private int quantity;

	public OrderItem(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }
}