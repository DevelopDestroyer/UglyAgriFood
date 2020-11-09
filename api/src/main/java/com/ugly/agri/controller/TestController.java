package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = {"1. Test"})
@Slf4j
@AllArgsConstructor
public class TestController {
    @ApiOperation(value = "테스트 조회", notes = "테스트 세 조회")
    @GetMapping("/test")
    public Response<String> getTest() {
        log.info("api test");
        return Response.ok("test 성공");
    }
}
