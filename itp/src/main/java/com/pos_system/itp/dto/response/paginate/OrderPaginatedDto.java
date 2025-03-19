package com.pos_system.itp.dto.response.paginate;

import com.pos_system.itp.dto.response.OrderResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaginatedDto {
    private List<OrderResponseDto> dataList;
    private int count;
}