package com.pos_system.itp.service;

import com.pos_system.itp.dto.request.OrderRequestDto;
import com.pos_system.itp.dto.response.OrderResponseDto;
import com.pos_system.itp.dto.response.paginate.OrderPaginatedDto;

import java.util.List;

public interface OrderService {
    public void createOrder(OrderRequestDto dto);

    public List<OrderResponseDto> getAll();

}


