package com.server.chucked.api.product.domain;

import com.server.chucked.api.product.domain.dto.ProductInternalDto;

public interface ProductProcessor {
    public ProductInternalDto.Create create(final ProductInternalDto.Create dto);
}
