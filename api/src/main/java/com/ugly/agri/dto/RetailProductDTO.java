package com.ugly.agri.dto;

import com.ugly.agri.domain.RetailProduct;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RetailProductDTO {
    private String name;
    private String kind;
    private String grade;
    private Integer todayAvgPrice;
    private Integer oneDayAvgPrice;
    private Integer oneWeekAvgPrice;
    private Integer twoWeekAvgPrice;
    private Integer oneMonthAvgPrice;
    private Integer oneYearAvgPrice;

    public static RetailProductDTO of(RetailProduct retailProduct) {
        return RetailProductDTO.builder()
                .name(retailProduct.getName())
                .kind(retailProduct.getKind())
                .grade(retailProduct.getGrade())
                .todayAvgPrice(Integer.parseInt(retailProduct.getTodayAvgPrice().replaceAll(",", "")))
                .oneDayAvgPrice(Integer.parseInt(retailProduct.getOneDayAvgPrice().replaceAll(",", "")))
                .oneWeekAvgPrice(Integer.parseInt(retailProduct.getOneWeekAvgPrice().replaceAll(",", "")))
                .twoWeekAvgPrice(Integer.parseInt(retailProduct.getTwoWeekAvgPrice().replaceAll(",", "")))
                .oneMonthAvgPrice(Integer.parseInt(retailProduct.getOneMonthAvgPrice().replaceAll(",", "")))
                .oneYearAvgPrice(Integer.parseInt(retailProduct.getOneYearAvgPrice().replaceAll(",", "")))
                .build();
    }
}
