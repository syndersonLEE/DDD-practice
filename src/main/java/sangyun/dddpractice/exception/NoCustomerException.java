package sangyun.dddpractice.exception;

public class NoCustomerException extends RuntimeException {
	public NoCustomerException() {
		super("고객이 존재 하지 않습니다");
	}
}
