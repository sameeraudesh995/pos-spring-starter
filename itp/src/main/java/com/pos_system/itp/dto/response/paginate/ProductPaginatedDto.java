package com.pos_system.itp.dto.response.paginate;

import com.pos_system.itp.dto.response.CustomerResponseDto;
import com.pos_system.itp.dto.response.ProductResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPaginatedDto {
    private long count;
    private List<ProductResponseDto> dataList;
}
