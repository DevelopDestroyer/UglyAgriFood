package com.ugly.agri.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String categoryName;
}
