package se.lexicon.E_commerce_platform.dto;

import se.lexicon.E_commerce_platform.entity.OrderStatus;

import java.time.Instant;
import java.util.List;

public record OrderResponse(
        Long id,
        Instant orderDate,
        OrderStatus status,
        Long customerId,
        List<OrderItemResponse> items
) {
}
