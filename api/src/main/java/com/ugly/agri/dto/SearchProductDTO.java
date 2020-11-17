package com.ugly.agri.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchProductDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String categoryName;
}
