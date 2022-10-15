package sangyun.dddpractice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import sangyun.dddpractice.domian.Customer;
import sangyun.dddpractice.domian.supporter.Money;
import sangyun.dddpractice.domian.OrderLine;
import sangyun.dddpractice.infrastructure.DroolsRuleEngine;
import sangyun.dddpractice.repository.CustomerRepository;

@Service
public class CalculateDiscountService {
	private DroolsRuleEngine droolsRuleEngine;
	private CustomerRepository customerRepository;

	public CalculateDiscountService(DroolsRuleEngine droolsRuleEngine, CustomerRepository customerRepository) {
		this.droolsRuleEngine = droolsRuleEngine;
		this.customerRepository = customerRepository;
	}

	public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
		Customer customer = customerRepository.getReferenceById(Long.parseLong(customerId));

		Money money = new Money(0);
		List<?> facts = Arrays.asList(customer, money);
		// facts.addAll(orderLines);
		droolsRuleEngine.evaluate("discountCalculation", facts);
		return money;
	}
}
