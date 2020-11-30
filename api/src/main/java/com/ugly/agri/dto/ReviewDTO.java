package com.ugly.agri.dto;

import com.ugly.agri.domain.Review;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReviewDTO {
    private Long reviewId;
    private Long productId;
    private Long userId;
    private String userName;
    private String productName;
    private String content;

    public static ReviewDTO of(Review review) {
        return ReviewDTO.builder()
                .reviewId(review.getId())
                .productId(review.getProduct().getId())
                .userId(review.getUser().getId())
                .userName(review.getUser().getName())
                .productName(review.getProduct().getTitle())
                .content(review.getContent())
                .build();
    }
}