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
    @NotNull
    private final Long retailProductId;
//    @NotBlank
//    private final String imageUrl;


//    public static RequestProductDTO of(Product product) {
//        return RequestProductDTO.builder()
//                .id(product.getId())
//                .name(product.getName())
//                .price(product.getPrice())
//                .comment(product.getComment())
//                .imageUrl(product.getImageUrl())
//                .userDTO(UserDTO.of(product.getUser()))
//                .category(product.getCategory())
//                .build();
//    }

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
                .build();
    }
}
