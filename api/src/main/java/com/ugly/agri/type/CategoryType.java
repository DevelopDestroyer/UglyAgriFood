package com.ugly.agri.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// 카테고리 종류
public enum CategoryType {
    AGRICULTURAL_PRODUCTS("농산물"),
    MARINE_PRODUCTS("수산물"),
    LIVESTOCK_PRODUCTS("축산물"),
    PROCESSED_PRODUCTS("가공품"),
    ETC("기타");

    private final String category;
}