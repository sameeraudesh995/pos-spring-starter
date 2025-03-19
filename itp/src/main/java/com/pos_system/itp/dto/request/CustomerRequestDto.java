package com.pos_system.itp.dto.request;

import lombok.*;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerRequestDto {
    private String name;
    private String address;
    private double salary;
}
