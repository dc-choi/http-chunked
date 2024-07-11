package com.server.chucked.api.product.domain;

import com.server.chucked.api.product.domain.dto.ProductInternalDto;
import com.server.chucked.api.product.domain.entity.Product;

public interface ProductProcessor {
    public Product get();
    public ProductInternalDto.Create create(final ProductInternalDto.Create dto);
}
