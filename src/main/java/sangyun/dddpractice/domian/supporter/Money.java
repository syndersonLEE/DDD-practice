package sangyun.dddpractice.domian.supporter;

import jakarta.persistence.Embeddable;

@Embeddable
public class Money {
	private int value;

	public Money(int value) {
		this.value = value;
	}

	public Money() {};

	public Money add(Money money) {
		return new Money(this.value + money.value);
	}

	public Money multifly(int multiflier) {
		return new Money(value * multiflier);
	}
}
