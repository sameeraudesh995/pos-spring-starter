package com.pos_system.itp.dto.request;


import com.pos_system.itp.entity.Customer;
import com.pos_system.itp.entity.OrderItem;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {
    private Customer customer;
    private List<OrderItem> items;
}