package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
@Api(tags = {"8. file"})
@AllArgsConstructor
@Slf4j
public class FileController {
    private final FileService fileService;

    @ApiOperation(value = "상품 이미지 등록")
    @PostMapping("/product/{id}")
    public Response<String> createProductImg(@PathVariable Long id, @RequestParam("file") List<MultipartFile> fileList) throws IOException {
        fileService.createProductImg(id, fileList);
        return Response.ok();
    }
}