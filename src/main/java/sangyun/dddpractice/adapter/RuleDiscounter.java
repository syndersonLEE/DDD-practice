package sangyun.dddpractice.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import sangyun.dddpractice.domian.Customer;
import sangyun.dddpractice.domian.OrderLine;
import sangyun.dddpractice.domian.supporter.Money;

@Component
public interface RuleDiscounter {
	public Money applyRules(Customer customer, List<OrderLine> orderLines);
}
