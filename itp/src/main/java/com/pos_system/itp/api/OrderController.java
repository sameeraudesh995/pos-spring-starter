package com.pos_system.itp.api;

import com.pos_system.itp.dto.request.OrderRequestDto;
import com.pos_system.itp.dto.response.paginate.OrderPaginatedDto;
import com.pos_system.itp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


}