package com.server.chucked.api.product.domain.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.server.chucked.api.product.domain.entity.Product;
import lombok.RequiredArgsConstructor;

import static com.server.chucked.api.product.domain.entity.QProduct.product;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Product findByName(String name) {
        return queryFactory
                .selectFrom(product)
                .where(product.name.eq(name))
                .fetchOne();
    }
}
