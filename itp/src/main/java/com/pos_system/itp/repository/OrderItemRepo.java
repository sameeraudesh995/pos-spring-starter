package com.pos_system.itp.repository;

import com.pos_system.itp.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderItemRepo extends JpaRepository<OrderItem, String> {
    @Query(value = "SELECT * FROM order_item WHERE order_id=?1",nativeQuery = true)
    Optional<OrderItem> findByOrderId(String OrderId);

}
