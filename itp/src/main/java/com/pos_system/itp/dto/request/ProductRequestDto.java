package com.pos_system.itp.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequestDto {
    private String name;
    private String description;
    private double price;
    private int quantity;
}
