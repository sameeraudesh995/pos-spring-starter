package com.pos_system.itp.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRequestDto {
    private String email;
    private String password;
    private String name;
}
