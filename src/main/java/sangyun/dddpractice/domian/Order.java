package sangyun.dddpractice.domian;

import java.util.List;
import sangyun.dddpractice.domian.OrderState;

public class Order {
	private List<OrderLine> orderLines;
	private int totalAmounts;
	private ShippingInfo shippingInfo;
	private OrderState state;

	public Order(List<OrderLine> orderLines) {
		setOrderLines(orderLines);
		setShippingInfo(shippingInfo);
	}

	private void setShippingInfo(ShippingInfo shippingInfo) {
		if(shippingInfo == null)
			throw new IllegalArgumentException("Shipping Info가 없음");
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

	public void changeShippingInfo(ShippingInfo newShippingInfo) {
		verifyNotYetShipped();
		setShippingInfo(newShippingInfo);
	}

	public void cancel() {
		verifyNotYetShipped();
		this.state = OrderState.CANCELED;
	}

	private void verifyNotYetShipped() {
		if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPAREING)
			throw  new IllegalArgumentException("이미 배송 시작했습니다.");
	}
	private void calculateTotalAmounts() {
	}
}
