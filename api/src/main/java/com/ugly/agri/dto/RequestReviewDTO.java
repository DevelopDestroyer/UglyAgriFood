package com.ugly.agri.dto;

import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.Review;
import com.ugly.agri.domain.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestReviewDTO {
    private Long userId;
    private Long productId;
    private String content;

    public Review toEntity(User user, Product product) {
        return Review.builder()
                .user(user)
                .product(product)
                .content(content)
                .build();
    }
}
