package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.dto.ProductDTO;
import com.ugly.agri.dto.RequestProductDTO;
import com.ugly.agri.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Api(tags = {"3. Product"})
@AllArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @ApiOperation(value = "전체 상품 조회")
    @GetMapping
    public Response<List<ProductDTO>> getProducts() {
        return Response.ok(productService.getProducts());
    }

    @ApiOperation(value = "상품 조회")
    @GetMapping("/{id}")
    public Response<ProductDTO> getProduct(@PathVariable Long id) {
        return Response.ok(productService.getProduct(id));
    }

    @ApiOperation(value = "상품 등록")
    @PostMapping
    public Response<ProductDTO> createProduct(@RequestBody @Valid RequestProductDTO requestProductDTO) {
        return Response.ok(productService.createProduct(requestProductDTO));
    }

    @ApiOperation(value = "상품 수정")
    @PutMapping("/{id}")
    public Response<ProductDTO> updateProduct(@PathVariable Long id,
                                              @RequestBody @Valid RequestProductDTO requestProductDTO) {
        return Response.ok(productService.updateProduct(id, requestProductDTO));
    }

    @ApiOperation(value = "상품 삭제")
    @DeleteMapping("/{id}")
    public Response<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return Response.ok();
    }
}