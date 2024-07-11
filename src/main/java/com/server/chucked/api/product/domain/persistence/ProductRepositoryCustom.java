package com.server.chucked.api.product.domain.persistence;

import com.server.chucked.api.product.domain.entity.Product;

public interface ProductRepositoryCustom {
    Product findByName(String name);
}
