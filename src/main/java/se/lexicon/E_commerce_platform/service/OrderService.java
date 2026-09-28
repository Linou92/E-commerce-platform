package se.lexicon.E_commerce_platform.service;

import jakarta.transaction.Transactional;
import se.lexicon.E_commerce_platform.dto.OrderRequest;
import se.lexicon.E_commerce_platform.dto.OrderResponse;
import se.lexicon.E_commerce_platform.dto.ProductRequest;

public interface OrderService {

    @Transactional
    OrderResponse placeOrder (OrderRequest request);
}
