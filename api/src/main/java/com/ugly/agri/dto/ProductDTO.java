package com.ugly.agri.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.RetailProduct;
import com.ugly.agri.type.CategoryType;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {
    private final Long id;
    private final String name;
    private final Long price;
    private final String comment;
    private final String imageUrl;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final UserDTO userDTO;
    private final CategoryType category;
    private final RetailProduct retailProduct;

    public static ProductDTO of(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .comment(product.getComment())
                .imageUrl(product.getImageUrl())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .userDTO(UserDTO.of(product.getUser()))
                .category(product.getCategory())
                .retailProduct(product.getRetailProduct())
                .build();
    }
}
