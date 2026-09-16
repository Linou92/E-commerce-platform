package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.E_commerce_platform.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);

    List<OrderItem> findByProductId(Long productId);

    List<OrderItem> findByQuantityGreaterThan(Integer quantity);
}
