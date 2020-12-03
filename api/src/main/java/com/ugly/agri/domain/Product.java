package com.ugly.agri.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;
import com.ugly.agri.type.CategoryType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 제목
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryType category;

    // 생상 지역
    @Column(name = "production_area", nullable = false)
    private String productionArea;

    // 생산 일자
    @Column(name = "production_date", nullable = false)
    private LocalDate productionDate;

    @Column(name = "price", nullable = false)
    private Long price;

    // 소개
    @Column(name = "introduction", nullable = false)
    private String introduction;

    @ManyToOne
    @JoinColumn(name = "retail_product_id")
    private RetailProduct retailProduct;

    // 원산지
    @Column(name = "origin", nullable = false)
    private String origin;

    // 생산자
    @Column(name = "producer", nullable = false)
    private String producer;

    // 보관 방법
    @Column(name = "storage_method", nullable = false)
    private String storageMethod;

    // 단위 중량
    @Column(name = "weight_per_unit", nullable = false)
    private String weightPerUnit;

    // 구성
    @Column(name = "composition", nullable = false)
    private String composition;

    // 메인 이미지
    @Column(name = "main_image_path")
    private String mainImagePath;

    // 썸네일 이미지
    @Column(name = "thumbnail_image_path")
    private String thumbnailImagePath;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Review> reviews = Lists.newArrayList();
}