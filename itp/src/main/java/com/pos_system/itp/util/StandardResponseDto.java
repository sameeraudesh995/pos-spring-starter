package com.pos_system.itp.util;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseDto {
    private int status;
    private String message;
    private Object data;

}
