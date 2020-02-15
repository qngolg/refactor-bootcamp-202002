package cc.xpbootcamp.warmup.cashier;

public class OrderItem {
	private String name;
	private double price;
	private int qty;

	public OrderItem(String name, double price, int qty) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public String getDescription() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return qty;
	}

    double totalAmount() {
        return price * qty;
    }
}