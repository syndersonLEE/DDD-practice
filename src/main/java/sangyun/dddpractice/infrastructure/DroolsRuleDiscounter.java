package sangyun.dddpractice.infrastructure;

import java.util.List;

import sangyun.dddpractice.adapter.RuleDiscounter;
import sangyun.dddpractice.domian.Customer;
import sangyun.dddpractice.domian.OrderLine;
import sangyun.dddpractice.domian.supporter.Money;

public class DroolsRuleDiscounter implements RuleDiscounter {
	@Override
	public Money applyRules(Customer customer, List<OrderLine> orderLines) {
		return new Money(0);
	}
}
