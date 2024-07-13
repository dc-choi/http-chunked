package com.server.chucked.api.product.domain;

import com.server.chucked.api.product.domain.dto.ProductInternalDto;
import com.server.chucked.api.product.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductProcessor {
    public Page<Product> findAll(Pageable pageable);
    public ProductInternalDto.Create create(final ProductInternalDto.Create dto);
}
