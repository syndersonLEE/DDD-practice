package sangyun.dddpractice;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import sangyun.dddpractice.adapter.RuleDiscounter;
import sangyun.dddpractice.exception.NoCustomerException;
import sangyun.dddpractice.repository.CustomerRepository;
import sangyun.dddpractice.service.CalculateDiscountService;

public class CalculateDiscountServiceTest {

	@Mock
	private CustomerRepository stubRepo;

	@Test
	public void noCustomer_thenExceptionShouldBeThrown() {
		when(stubRepo.findById(0L)).thenReturn(null);
		RuleDiscounter stubRule = (cust, lines) -> null;

		CalculateDiscountService calDisSvc =
			new CalculateDiscountService(stubRule, stubRepo);
	}

}
