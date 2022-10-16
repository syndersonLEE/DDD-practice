package sangyun.dddpractice.domian;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import sangyun.dddpractice.domian.supporter.OrderState;
import sangyun.dddpractice.domian.supporter.ShippingInfo;

@Entity
public class Order {
	@Id
	private Long id;

	@Embedded
	private Orderer orderer;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private List<OrderLine> orderLines;
	private int totalAmounts;
	@Embedded
	private ShippingInfo shippingInfo;
	private OrderState state;
	private String orderNumber;

	public Order(List<OrderLine> orderLines) {
		setOrderLines(orderLines);
		setShippingInfo(shippingInfo);
	}

	public Order() {}

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
		this.totalAmounts = orderLines
			.stream()
			.mapToInt(x -> x.getAmounts())
			.sum();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(obj.getClass() != Order.class) return false;
		Order other = (Order)obj;
		if (this.orderNumber == null) return false;
		return this.orderNumber.equals(other.orderNumber);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		return result;
	}
}
