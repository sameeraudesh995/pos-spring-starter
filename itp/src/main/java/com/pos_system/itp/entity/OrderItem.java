package com.pos_system.itp.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    private String orderItemId;

    @Column(name = "qty", nullable = false, length = 225 )
    private int qty;

    @Column(name = "description",nullable = false,length = 225)
    private String description;

    @Column(name = "net_total",nullable = false,scale = 2)
    private double netTotal;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}