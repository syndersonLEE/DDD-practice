package sangyun.dddpractice.domian;

import java.util.List;

public class Order {
	private List<OrderLine> orderLines;
	private int totalAmounts;
	private ShippingInfo shippingInfo;
	private OrderState state;

	public Order(List<OrderLine> orderLines) {
		setOrderLines(orderLines);
		setShippingInfo(shippingInfo);
	}

	public void changeShippingInfo(ShippingInfo newShippingInfo) {
		verifyNotYetShipped();
		setShippingInfo(newShippingInfo);
	}

	public void cancel() {
		verifyNotYetShipped();
		this.state = OrderState.CANCELED;
	}

	private void verifyNotYetShipped() {
		if(state != OrderState.PAYMENT_WAITING &&
			state != OrderState.PREPAREING)
			throw new IllegalArgumentException("이미 전달 함");
	}

	private void setShippingInfo(ShippingInfo shippingInfo) {
		if(shippingInfo == null)
			throw new IllegalArgumentException("Shipping Info가 없음");
	}

	private void setOrderLines(List<OrderLine> orderLines) {
		verifyAtLeastOnceOrMoreOrderLines(orderLines);
		this.orderLines = orderLines;
	}

	private void verifyAtLeastOnceOrMoreOrderLines(List<OrderLine> orderLines) {
		if(orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("OrderLine Null값");
		}
	}

	private void calculateTotalAmounts() {
	}
}
