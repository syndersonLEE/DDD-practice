package sangyun.dddpractice.domian;

public class Money {
	private int value;

	public Money(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public Money add(Money money) {
		return new Money(this.value + money.value);
	}

	public Money multifly(int multiflier) {
		return new Money(value * multiflier);
	}
}
