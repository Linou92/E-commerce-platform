package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.E_commerce_platform.entity.Order;
import se.lexicon.E_commerce_platform.entity.OrderStatus;

import java.time.Instant;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

    @EntityGraph(attributePaths = "items")
    List<Order> findByStatus(OrderStatus status);

    List<Order> findByOrderDateAfter(Instant date);

    List<Order> findByOrderDateBetween(Instant start, Instant end);

    List<Order> findDistinctByItemsProductId(Long productId);

    long countByStatus(OrderStatus status);

    List<Order> findByCustomerIdAndStatus(Long customerId, OrderStatus status);
}
