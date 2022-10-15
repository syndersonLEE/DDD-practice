package sangyun.dddpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sangyun.dddpractice.domian.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
