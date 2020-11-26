package com.ugly.agri.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
@Data
public class SearchProductDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String categoryName;
}
