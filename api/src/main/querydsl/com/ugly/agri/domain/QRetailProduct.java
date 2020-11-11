package com.ugly.agri.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRetailProduct is a Querydsl query type for RetailProduct
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRetailProduct extends EntityPathBase<RetailProduct> {

    private static final long serialVersionUID = -435493999L;

    public static final QRetailProduct retailProduct = new QRetailProduct("retailProduct");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DatePath<java.util.Date> createdAt = _super.createdAt;

    public final StringPath grade = createString("grade");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath kind = createString("kind");

    public final StringPath name = createString("name");

    public final StringPath oneDayAvgPrice = createString("oneDayAvgPrice");

    public final StringPath oneMonthAvgPrice = createString("oneMonthAvgPrice");

    public final StringPath oneWeekAvgPrice = createString("oneWeekAvgPrice");

    public final StringPath oneYearAvgPrice = createString("oneYearAvgPrice");

    public final StringPath todayAvgPrice = createString("todayAvgPrice");

    public final StringPath twoWeekAvgPrice = createString("twoWeekAvgPrice");

    //inherited
    public final DatePath<java.util.Date> updatedAt = _super.updatedAt;

    public QRetailProduct(String variable) {
        super(RetailProduct.class, forVariable(variable));
    }

    public QRetailProduct(Path<? extends RetailProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRetailProduct(PathMetadata metadata) {
        super(RetailProduct.class, metadata);
    }

}

