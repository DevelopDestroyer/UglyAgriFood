package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = {"1. Category"})
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @ApiOperation(value = "전체 카테고리 조회")
    @GetMapping("/categories")
    public Response<List<String>> getCategories() {
        return Response.ok(categoryService.getCategories());
    }
}
