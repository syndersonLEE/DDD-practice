package sangyun.dddpractice.domian.supporter;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import sangyun.dddpractice.domian.Address;
import sangyun.dddpractice.domian.Receiver;

@Getter
@Embeddable
public class ShippingInfo {
	/**
	 * Value Type을 클래스로 분리
	 */
	private Receiver reciever;
	private Address address;

	public ShippingInfo(Receiver reciever, Address address) {
		this.reciever = reciever;
		this.address = address;
	}
}
