package com.server.chucked.api.product.application;

import com.server.chucked.api.product.application.mapstruct.ProductMapstructMapper;
import com.server.chucked.api.product.domain.ProductProcessor;
import com.server.chucked.api.product.domain.dto.ProductInternalDto;
import com.server.chucked.api.product.presentation.dto.CreateProductExternalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductMapstructMapper productMapstructMapper;
    private final ProductProcessor productProcessor;

    @Transactional
    public CreateProductExternalDto.Response create(final CreateProductExternalDto.Request request) {
        ProductInternalDto.Create dto = productMapstructMapper.of(request);

        ProductInternalDto.Create created = productProcessor.create(dto);

        return productMapstructMapper.of(created);
    }
}
