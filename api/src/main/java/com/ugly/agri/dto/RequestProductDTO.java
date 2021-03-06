package com.ugly.agri.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.RetailProduct;
import com.ugly.agri.domain.User;
import com.ugly.agri.type.CategoryType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestProductDTO implements Serializable {
    @NotNull
    private final Long userId;
    @NotBlank
    private final String title;
    @NotBlank
    private final String category;
    @NotBlank
    private final String productionArea;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final LocalDate productionDate;
    @PositiveOrZero
    private final Long price;
    @NotBlank
    private final String introduction;
    @NotBlank
    private final String origin;
    @NotBlank
    private final String producer;
    @NotBlank
    private final String storageMethod;
    @NotBlank
    private final String weightPerUnit;
    @NotBlank
    private final String composition;

    public Product toEntity(User user, RetailProduct retailProduct) {
        return Product.builder()
                .user(user)
                .title(title)
                .category(CategoryType.constantOf(category))
                .productionArea(productionArea)
                .productionDate(productionDate)
                .price(price)
                .introduction(introduction)
                .retailProduct(retailProduct)
                .origin(origin)
                .producer(producer)
                .storageMethod(storageMethod)
                .weightPerUnit(weightPerUnit)
                .composition(composition)
                .mainImagePath(null)
                .thumbnailImagePath(null)
                .build();
    }
}
