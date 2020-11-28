package com.ugly.agri.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @Column(name = "production_area", nullable = false)
    private String productionArea;

    @Column(name = "production_date", nullable = false)
    private LocalDate productionDate;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "introduction", nullable = false)
    private String introduction;

    @ManyToOne
    @JoinColumn(name = "retail_product_id")
    private RetailProduct retailProduct;

//    @Column(name = "image_url", nullable = false)
//    private String imageUrl;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Review> reviews;
}