package com.ugly.agri.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ugly.agri.domain.Product;
import com.ugly.agri.dto.SearchProductDTO;
import com.ugly.agri.type.CategoryType;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ugly.agri.domain.QProduct.product;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public ProductRepositorySupport(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }

    public List<Product> findByCondition(SearchProductDTO searchProductDTO) {
        BooleanBuilder builder = new BooleanBuilder();
        if (searchProductDTO.getName() != null) {
            builder.and(product.name.contains(searchProductDTO.getName()));
        }

        if (searchProductDTO.getCategoryName() != null) {
            CategoryType type = CategoryType.constantOf(searchProductDTO.getCategoryName());
            builder.and(product.category.eq(type));
        }

        builder.and(product.isDeleted.eq(false));

        return queryFactory.selectFrom(product)
                .where(builder)
                .fetch();
    }
}