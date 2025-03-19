package com.pos_system.itp.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItemDto {
    private String productId;
    private int qty;
}