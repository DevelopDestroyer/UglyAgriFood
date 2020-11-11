package com.ugly.agri.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "retail_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetailProduct extends BaseEntity {
    // 상품명
    @Column(name = "name")
    private String name;

    // 상품 종류
    @Column(name = "kind")
    private String kind;

    // 상품 등급
    @Column(name = "grade")
    private String grade;

    // 당일 평균 가격
    @Column(name = "today_avg_price")
    private String todayAvgPrice;

    // 1일전 평균 가격
    @Column(name = "one_day_avg_price")
    private String oneDayAvgPrice;

    // 1주전 평균 가격
    @Column(name = "one_week_avg_price")
    private String oneWeekAvgPrice;

    // 2주전 평균 가격
    @Column(name = "two_week_avg_price")
    private String twoWeekAvgPrice;

    // 1달전 평균 가격
    @Column(name = "one_month_avg_price")
    private String oneMonthAvgPrice;

    // 1달전 평균 가격
    @Column(name = "one_year_avg_price")
    private String oneYearAvgPrice;
}
