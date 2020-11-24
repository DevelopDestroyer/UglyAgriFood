package com.ugly.agri.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.RetailProduct;
import com.ugly.agri.domain.User;
import com.ugly.agri.type.CategoryType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestProductDTO implements Serializable {
    @NotNull
    private final Long id;
    @NotBlank
    private final String name;
    @NotNull
    private final Integer price;
    @NotBlank
    private final String comment;
    @NotBlank
    private final String imageUrl;
    @NotNull
    private final UserDTO userDTO;
    @NotNull
    private final CategoryType category;
    @NotNull
    private final RetailProduct retailProduct;


    public static RequestProductDTO of(Product product) {
        return RequestProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .comment(product.getComment())
                .imageUrl(product.getImageUrl())
                .userDTO(UserDTO.of(product.getUser()))
                .category(product.getCategory())
                .build();
    }

    public Product toEntity(User user) {
        return Product.builder()
                .user(user)
                .name(name)
                .price(price)
                .comment(comment)
                .imageUrl(imageUrl)
                .category(category)
                .retailProduct(retailProduct)
                .build();
    }
}
