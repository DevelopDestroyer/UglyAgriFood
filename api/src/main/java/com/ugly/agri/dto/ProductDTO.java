package com.ugly.agri.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.RetailProduct;
import com.ugly.agri.domain.Review;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.OptionalDouble;

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
    private final String origin;
    private final String producer;
    private final String storageMethod;
    private final String weightPerUnit;
    private final String composition;
    private final String mainImagePath;
    private final String thumbnailImagePath;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Integer pricePercent;

    private final Integer reviewCount;
    private final double reviewGradeAvg;

    public static ProductDTO of(Product product) {
        if(product.getReviews() == null) {
            product.setReviews(Lists.newArrayList());
        }

        OptionalDouble gradeAvg = product.getReviews().stream().mapToDouble(Review::getGrade).average();

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
                .origin(product.getOrigin())
                .producer(product.getProducer())
                .storageMethod(product.getStorageMethod())
                .weightPerUnit(product.getWeightPerUnit())
                .mainImagePath(product.getMainImagePath())
                .thumbnailImagePath(product.getThumbnailImagePath())
                .composition(product.getComposition())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .pricePercent((int) (product.getPrice() * 100 /
                        Integer.parseInt(product.getRetailProduct().getTodayAvgPrice().replaceAll(",", ""))))
                .reviewCount(product.getReviews() == null ? 0 : product.getReviews().size())
                .reviewGradeAvg(gradeAvg.isPresent() ? gradeAvg.getAsDouble() : 0)
                .build();
    }
}
