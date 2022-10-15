package sangyun.dddpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sangyun.dddpractice.domian.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
