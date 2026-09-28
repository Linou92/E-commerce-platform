package se.lexicon.E_commerce_platform.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import se.lexicon.E_commerce_platform.dto.OrderItemRequest;
import se.lexicon.E_commerce_platform.dto.OrderRequest;
import se.lexicon.E_commerce_platform.dto.OrderResponse;
import se.lexicon.E_commerce_platform.entity.*;
import se.lexicon.E_commerce_platform.exception.ResourceNotFoundException;
import se.lexicon.E_commerce_platform.mapper.OrderMapper;
import se.lexicon.E_commerce_platform.repository.CustomerRepository;
import se.lexicon.E_commerce_platform.repository.OrderRepository;
import se.lexicon.E_commerce_platform.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, CustomerRepository customerRepository, OrderMapper orderMapper) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    @Override
    public OrderResponse placeOrder(OrderRequest request){

        // 1. find the customer
        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + request.customerId() + " not found"));

        // 2. create the order
        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.CREATED);

        // 3. for each requested item, find the product
        for (OrderItemRequest itemRequest : request.items()){
            Product product = productRepository.findById(itemRequest.productId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product with id " + itemRequest.productId() + " not found"));

            // create order item
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.quantity());

            // get the current product price
            orderItem.setPriceAtPurchase(product.getPrice());

            // add item to order
            order.addItem(orderItem);
        }

        // 4. save order and its items
        Order savedOrder = orderRepository.save(order);

        // 5. convert to response dto
        return orderMapper.toResponse(savedOrder);

    }
}
