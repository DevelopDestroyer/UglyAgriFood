package com.ugly.agri.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Data
// 상품
public class Product extends BaseEntity {
    // 가격 등록 일자
    @Column(name = "reg_day")
    private LocalDate regDay;

    // 품목코드
    @Column(name = "item_code")
    private String itemCode;

    // 품목명
    @Column(name = "item_name")
    private String itemName;

    // 품종코드
    @Column(name = "kind_code")
    private String kindCode;

    // 품종명
    @Column(name = "kind_name")
    private String kindName;

    // 평균가격
    @Column(name = "avg_price")
    private BigDecimal avgPrice;

    // 도소매 등 조사구분 : 01 도매, 02 소매
    @Column(name = "product_cls_code")
    private String productClsCode;

    // 조사구분명
    @Column(name = "product_cls_name")
    private String productClsName;

    // 등급코드
    @Column(name = "product_rank_code")
    private String productRankCode;

    // 등급명
    @Column(name = "product_rank_name")
    private String productRankName;

    // 유통단계별 단위
    @Column(name = "circ_unit")
    private String circUnit;

    // 유통단계별 무게
    @Column(name = "circ_unit_size")
    private String circUnitSize;

    // 등록회차
    @Column(name = "rcv_phs")
    private String rcvPhs;

    // 금일 최저가
    @Column(name = "min_price")
    private BigDecimal minPrice;

    // 금일 최대가
    @Column(name = "max_price")
    private BigDecimal maxPrice;
}
