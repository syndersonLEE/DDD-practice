package sangyun.dddpractice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import sangyun.dddpractice.adapter.RuleDiscounter;
import sangyun.dddpractice.domian.Customer;
import sangyun.dddpractice.domian.supporter.Money;
import sangyun.dddpractice.domian.OrderLine;
import sangyun.dddpractice.exception.NoCustomerException;
import sangyun.dddpractice.infrastructure.DroolsRuleEngine;
import sangyun.dddpractice.repository.CustomerRepository;

@Service
public class CalculateDiscountService {
	private RuleDiscounter ruleDiscounter;
	private CustomerRepository customerRepository;

	public CalculateDiscountService(RuleDiscounter ruleDiscounter, CustomerRepository customerRepository) {
		this.ruleDiscounter = ruleDiscounter;
		this.customerRepository = customerRepository;
	}

	public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
		Customer customer = customerRepository.findById(Long.parseLong(customerId)).orElseThrow();
		return ruleDiscounter.applyRules(customer, orderLines);

	}

	private Customer findCustomer(String customerId) {
		Customer customer = customerRepository
			.findById(Long.parseLong(customerId))
			.orElseThrow(
				() -> new NoCustomerException()
			);
		return customer;
	};
}
