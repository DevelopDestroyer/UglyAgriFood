package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.dto.MainDTO;
import com.ugly.agri.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
@Api(tags = {"0. Main"})
@AllArgsConstructor
public class MainController {
    private final MainService mainService;

    @ApiOperation(value = "메인 데이터 조회 (카테고리 + 추천 상품 + 시세보다 저렴한 상품 + 연관 상품)")
    @GetMapping
    public Response<MainDTO> getMainData() {
        return Response.ok(mainService.getMainData());
    }
}
