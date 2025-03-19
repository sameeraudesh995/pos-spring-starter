package com.pos_system.itp.repository;

import com.pos_system.itp.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {


        @Query("SELECT r FROM orders r WHERE FUNCTION('YEAR', r.date) = :year")
        List<Order> findByYear(int year);

}