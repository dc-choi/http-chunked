package com.server.chucked.api.product.domain;

import com.server.chucked.api.product.domain.dto.ProductInternalDto;
import com.server.chucked.api.product.domain.entity.Product;
import com.server.chucked.api.product.domain.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductProcessorImpl implements ProductProcessor {
    private final ProductRepository productRepository;

    @Override
    public ProductInternalDto.Create create(final ProductInternalDto.Create dto) {
        Product product = ProductInternalDto.Create.toEntity(dto);

        Product saved = productRepository.save(product);

        return ProductInternalDto.Create.of(saved);
    }
}
