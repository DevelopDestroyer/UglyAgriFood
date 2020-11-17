package com.ugly.agri.dto;

import lombok.Data;

import java.util.List;

@Data
public class MainDTO {
    private List<String> categoryNameList;
    private List<ProductDTO> recommendProductList;
    private List<ProductDTO> cheapProductList;
    private List<ProductDTO> relatedProductList;
}
