package com.ugly.agri.dto;

import com.ugly.agri.domain.RetailProduct;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseRetailProductDTO {
    private Long id;
    private String name;

    public static ResponseRetailProductDTO of(RetailProduct retailProduct) {
        return ResponseRetailProductDTO.builder()
                .id(retailProduct.getId())
                .name(retailProduct.getName())
                .build();
    }
}