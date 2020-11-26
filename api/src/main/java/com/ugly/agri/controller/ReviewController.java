package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.dto.*;
import com.ugly.agri.service.RetailProductService;
import com.ugly.agri.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Api(tags = {"6. Review"})
@AllArgsConstructor
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    @ApiOperation(value = "리뷰 리스트 조회")
    @GetMapping
    public Response<List<ReviewDTO>> getReviews(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long productId) {
        return Response.ok(reviewService.getReviews(userId, productId));
    }

    @ApiOperation(value = "리뷰 상세 조회")
    @GetMapping("/{id}")
    public Response<ReviewDTO> getReview(@PathVariable Long id) {
        return Response.ok(reviewService.getReview(id));
    }

    @ApiOperation(value = "리뷰 등록")
    @PostMapping
    public Response<ReviewDTO> createReview(@RequestBody RequestReviewDTO requestReviewDTO) {
        return Response.ok(reviewService.createReview(requestReviewDTO));
    }
}
