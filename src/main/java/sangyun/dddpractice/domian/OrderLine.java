package sangyun.dddpractice.domian;

public class OrderLine {
	private String product;
	private Money price;
	private int quantity;
	private Money amounts;

	public OrderLine(String product, Money price, int quantity, Money amounts) {
		this.product = product;
		this.price = new Money(price.getValue());
		this.quantity = quantity;
		this.amounts = calculateAmounts();
	}

	private Money calculateAmounts() {
		return new Money( price.getValue() * quantity);
	}

	public int getAmounts() {
		return amounts.getValue();
	}
}
