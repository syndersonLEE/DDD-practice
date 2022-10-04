package sangyun.dddpractice.domian;

import java.util.List;

public class Order {
	private List<OrderLine> orderLines;
	private int totalAmounts;

	public Order(List<OrderLine> orderLines) {
		setOrderLines(orderLines);
	}

	private void setOrderLines(List<OrderLine> orderLines) {
		verifyAtLeastOnnceOrMoreOrderLines(orderLines);
		this.orderLines = orderLines;
	}

	private void verifyAtLeastOnnceOrMoreOrderLines(List<OrderLine> orderLines) {
		if(orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("OrderLine Null값");
		}
	}

	private void calculateTotalAmounts() {
	}
}
