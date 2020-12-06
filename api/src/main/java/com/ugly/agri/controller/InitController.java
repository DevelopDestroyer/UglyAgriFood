package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.service.InitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/init")
@Api(tags = {"9. init"})
@AllArgsConstructor
@Slf4j
public class InitController {
    private final InitService initService;

    @ApiOperation(value = "데이터 초기화 후 샘플데이터 넣기")
    @PostMapping("/data")
    public Response<String> initData() throws IOException {
        initService.deleteDate();
        initService.setTestData();
        return Response.ok();
    }
}