package com.ugly.agri.dto;

import com.ugly.agri.domain.Review;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReviewDTO {
    private String productName;
    private String content;

    public static ReviewDTO of(Review review) {
        return ReviewDTO.builder()
                .productName(review.getProduct().getTitle())
                .content(review.getContent())
                .build();
    }
}