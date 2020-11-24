package com.ugly.agri.domain;

import com.ugly.agri.type.CategoryType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @ManyToOne
    @JoinColumn(name = "retail_product_id", nullable = false)
    private RetailProduct retailProduct;
}