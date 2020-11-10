package com.ugly.agri.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FoodPriceData {
    // 가격 등록 일자
    private String regDay;
    // 품목코드
    private String itemCode;
    // 품목명
    private String itemName;
    // 품종코드
    private String kindCode;
    // 품종명
    private String kindName;
    // 평균가격
    private String avgPrice;
    // 도소매 등 조사구분 : 01 도매, 02 소매
    private String productClsCode;
    // 조사구분명
    private String productClsName;
    // 등급코드
    private String productRankCode;
    // 등급명
    private String productRankName;
    // 유통단계별 단위
    private String circUnit;
    // 유통단계별 무게
    private String circUnitSize;
    // 등록회차
    private String rcvPhs;
    // 금일 최저가
    private String minPrice;
    // 금일 최대가
    private String maxPrice;
}
