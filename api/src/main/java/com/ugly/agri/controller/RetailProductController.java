package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.dto.ResponseRetailProductDTO;
import com.ugly.agri.service.RetailProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/retail_products")
@Api(tags = {"5. Retail Product"})
@AllArgsConstructor
@Slf4j
public class RetailProductController {
    private final RetailProductService retailProductService;

    @ApiOperation(value = "소매 상품 리스트 조회")
    @GetMapping
    public Response<List<ResponseRetailProductDTO>> getProducts() {
        return Response.ok(retailProductService.getRetailProducts());
    }
}
