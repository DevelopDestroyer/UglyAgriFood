package com.ugly.agri.dto;

import com.ugly.agri.domain.Order;
import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class RequestOrderDTO {
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;

    public Order toEntity(User user, Product product) {
        return Order.builder()
                .user(user)
                .product(product)
                .quantity(quantity)
                .paymentPrice(product.getPrice() * quantity)
                .build();
    }
}