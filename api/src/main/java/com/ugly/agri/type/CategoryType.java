package com.ugly.agri.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
// 카테고리 종류
public enum CategoryType {
    AGRICULTURAL_PRODUCTS("농산물"),
    MARINE_PRODUCTS("수산물"),
    LIVESTOCK_PRODUCTS("축산물"),
    PROCESSED_PRODUCTS("가공품"),
    ETC("기타");

    private String categoryName;
    private static Map map = new HashMap<>();

    static {
        for (CategoryType categoryType : CategoryType.values()) {
            map.put(categoryType.categoryName, categoryType);
        }
    }

    public static CategoryType constantOf(String categoryName) {
        CategoryType categoryType = (CategoryType) map.get(categoryName);
        if (categoryType == null){
            throw new IllegalArgumentException("일치하는 Enum 상수가 없습니다 : " + categoryName);
        }
        return categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }
}