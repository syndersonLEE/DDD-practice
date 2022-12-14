package sangyun.dddpractice.domian;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import sangyun.dddpractice.domian.supporter.Money;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String product;
	@Column(name = "order_id")
	private Long OrderId;
	private Money price;
	private int quantity;
	private Money amounts;

	public OrderLine(String product, Long orderId, Money price, int quantity, Money amounts) {
		this.product = product;
		OrderId = orderId;
		this.price = price;
		this.quantity = quantity;
		this.amounts = amounts;
	}

	public OrderLine() {}

	private Money calculateAmounts() {
		return new Money( price.getValue() * quantity);
	}

	public int getAmounts() {
		return amounts.getValue();
	}
}
