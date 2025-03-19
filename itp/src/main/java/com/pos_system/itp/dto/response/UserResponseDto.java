package com.pos_system.itp.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserResponseDto {
    private String id;
    private String email;
    private String password;
    private String name;
}
