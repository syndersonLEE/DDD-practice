package sangyun.dddpractice.domian;

import lombok.Getter;

@Getter
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
