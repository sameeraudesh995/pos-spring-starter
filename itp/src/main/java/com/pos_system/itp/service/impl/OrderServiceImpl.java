package com.pos_system.itp.service.impl;

import com.pos_system.itp.dto.request.OrderItemDto;
import com.pos_system.itp.dto.request.OrderRequestDto;
import com.pos_system.itp.dto.response.CustomerResponseDto;
import com.pos_system.itp.dto.response.OrderResponseDto;
import com.pos_system.itp.dto.response.paginate.OrderPaginatedDto;
import com.pos_system.itp.entity.Customer;
import com.pos_system.itp.entity.Order;
import com.pos_system.itp.entity.OrderItem;
import com.pos_system.itp.entity.Product;
import com.pos_system.itp.repository.CustomerRepo;
import com.pos_system.itp.repository.OrderItemRepo;
import com.pos_system.itp.repository.OrderRepository;
import com.pos_system.itp.repository.ProductRepo;
import com.pos_system.itp.service.OrderService;
import lombok.AllArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerRepo customerRepository;
    private final ProductRepo productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepo orderItemRepository;

    @Override
    public void createOrder(OrderRequestDto dtoList) {
        if(dtoList == null){
            throw new RuntimeException("data was not found!");
        }
        Order createdOrder = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .date(new Date())
                .customer(dtoList.getCustomer())
                .build();

        orderRepository.save(createdOrder);

        for(OrderItem dto : dtoList.getItems()){
            Optional<Order> selectedOrder = orderRepository.findById(createdOrder.getOrderId());
            if(selectedOrder.isEmpty()){
                throw new RuntimeException("Order not found!");
            }
            Order selectedPlacedOrder = Order.builder()
                    .orderId(selectedOrder.get().getOrderId())
                    .date(selectedOrder.get().getDate())
                    .customer(selectedOrder.get().getCustomer())
                    .build();

            OrderItem selectedOrderItem = OrderItem.builder()
                    .orderItemId(UUID.randomUUID().toString())
                    .description(dto.getDescription())
                    .order(selectedPlacedOrder)
                    .netTotal(dto.getNetTotal())
                    .qty(dto.getQty())
                    .product(dto.getProduct())
                    .build();
            orderItemRepository.save(selectedOrderItem);


        }


    }

    @Override
    public List<OrderResponseDto> getAll() {
        return List.of();
    }
}