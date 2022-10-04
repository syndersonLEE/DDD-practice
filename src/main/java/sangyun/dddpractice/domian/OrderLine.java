package sangyun.dddpractice.domian;

public class OrderLine {
	private String product;
	private int price;
	private int quantity;
	private int amounts;

	public OrderLine(String product, int price, int quantity, int amounts) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.amounts = amounts;
	}

	private int calculateAmounts() {
		return price * quantity;
	}

	public int getAmounts() {
		return amounts;
	}
}
