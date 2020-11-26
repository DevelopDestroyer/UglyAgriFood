package com.ugly.agri.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.RetailProduct;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {
    private final Long id;
    private final UserDTO userDTO;
    private final String title;
    private final String category;
    private final String productionArea;
    private final LocalDate productionDate;
    private final Long price;
    private final String introduction;
    private final RetailProduct retailProduct;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Integer pricePercent;
//    private final String imageUrl;

    private final Integer reviewCount;

    public static ProductDTO of(Product product) {
        return ProductDTO.builder()
                .userDTO(UserDTO.of(product.getUser()))
                .id(product.getId())
                .title(product.getTitle())
                .category(product.getCategory().getCategoryName())
                .productionArea(product.getProductionArea())
                .productionDate(product.getProductionDate())
                .price(product.getPrice())
                .introduction(product.getIntroduction())
                .retailProduct(product.getRetailProduct())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .pricePercent(
                        (int) (product.getPrice() * 100 /
                                Integer.parseInt(product.getRetailProduct().getTodayAvgPrice().replaceAll(",", ""))))
                .reviewCount(product.getReview().size())
                .build();
    }
}
