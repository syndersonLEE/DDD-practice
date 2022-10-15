package sangyun.dddpractice.adapter;

import java.util.List;

import sangyun.dddpractice.domian.Customer;
import sangyun.dddpractice.domian.OrderLine;
import sangyun.dddpractice.domian.supporter.Money;

public interface RuleDiscounter {
	public Money applyRules(Customer customer, List<OrderLine> orderLines);
}
