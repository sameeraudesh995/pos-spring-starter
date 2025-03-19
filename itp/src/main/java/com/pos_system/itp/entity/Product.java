package com.pos_system.itp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name = "product")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "product_id",
            nullable = false)
    private String productId;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String description;
    @Column(length = 10, nullable = false)
    private double price;
    @Column(length = 10, nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems;
}
