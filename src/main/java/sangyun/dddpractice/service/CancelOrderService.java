package sangyun.dddpractice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sangyun.dddpractice.domian.Order;
import sangyun.dddpractice.exception.NoCustomerException;
import sangyun.dddpractice.repository.OrderRepository;

@Service
public class CancelOrderService {

	private OrderRepository orderRepository;

	public CancelOrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Transactional
	public void cancelOrder(String orderId) {
		Order order = orderRepository
			.findById(Long.parseLong(orderId))
			.orElseThrow(
				() -> new NoCustomerException()
			);
	}
}
