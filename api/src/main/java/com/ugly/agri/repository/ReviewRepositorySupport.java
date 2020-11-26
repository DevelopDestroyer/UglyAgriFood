package com.ugly.agri.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ugly.agri.domain.Product;
import com.ugly.agri.domain.Review;
import com.ugly.agri.dto.RequestReviewDTO;
import com.ugly.agri.dto.SearchProductDTO;
import com.ugly.agri.type.CategoryType;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ugly.agri.domain.QReview.review;

@Repository
public class ReviewRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public ReviewRepositorySupport(JPAQueryFactory queryFactory) {
        super(Review.class);
        this.queryFactory = queryFactory;
    }

    public List<Review> findByCondition(Long userId, Long productId) {
        BooleanBuilder builder = new BooleanBuilder();
        if (userId != null) {
            builder.and(review.product.id.eq(userId));
        }

        if (productId != null) {
            builder.and(review.user.id.eq(productId));
        }

        return queryFactory.selectFrom(review)
                .where(builder)
                .fetch();
    }
}