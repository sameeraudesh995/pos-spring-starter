package com.pos_system.itp.dto.response;

import com.pos_system.itp.entity.Customer;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderResponseDto {
    private String OrderId;
    private Date createAt;
    private String customer;
    private int itemCount;
}