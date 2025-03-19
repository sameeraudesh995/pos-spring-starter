package com.pos_system.itp.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductResponseDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
