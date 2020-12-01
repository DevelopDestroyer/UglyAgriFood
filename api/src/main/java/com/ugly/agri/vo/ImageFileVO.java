package com.ugly.agri.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageFileVO implements Serializable {
    private final Long product_id;
    private final String mainImageFullPath;
    private final String thumbnailImageFullPath;
    private final String mainImageUrlPath;
    private final String thumbnailImageUrlPath;
}
