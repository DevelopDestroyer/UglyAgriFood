package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.domain.Order;
import com.ugly.agri.dto.RequestOrderDTO;
import com.ugly.agri.service.CategoryService;
import com.ugly.agri.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Api(tags = {"4. Order"})
@AllArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @ApiOperation(value = "해당 사용자 ID의 주문 내역 조회")
    @GetMapping
    public Response<List<Order>> getOrdersByUserId(@RequestParam("userId") Long userId) {
        return Response.ok(orderService.getOrdersByUserId(userId));
    }

    @ApiOperation(value = "주문 생성")
    @PostMapping
    public Response<Order> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) {
        return Response.ok(orderService.createOrder(requestOrderDTO));
    }

    @ApiOperation(value = "주문 상세 조회")
    @GetMapping("/{id}")
    public Response<Order> getOrder(@PathVariable("id") Long id) {
        return Response.ok(orderService.getOrder(id));
    }
}
