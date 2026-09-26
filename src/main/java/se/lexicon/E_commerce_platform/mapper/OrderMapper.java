package se.lexicon.E_commerce_platform.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.E_commerce_platform.dto.OrderItemResponse;
import se.lexicon.E_commerce_platform.dto.OrderResponse;
import se.lexicon.E_commerce_platform.entity.Order;
import se.lexicon.E_commerce_platform.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order) {

        List<OrderItemResponse> items = order.getItems()
                .stream()
                .map(this::toItemResponse)
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getOrderDate(),
                order.getStatus(),
                order.getCustomer().getId(),
                items
        );
    }

    private OrderItemResponse toItemResponse(OrderItem item) {
        return new OrderItemResponse(
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getQuantity(),
                item.getPriceAtPurchase()
        );
    }
}
