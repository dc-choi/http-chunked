package com.server.chucked.api.product.domain.dto;

import com.server.chucked.api.product.domain.entity.Product;
import lombok.Builder;

/**
 * Domain 1개당 DTO 1개
 */
public record ProductInternalDto() {
    @Builder
    public record Create(
            String name,
            Long price
    ) {
        public static Product toEntity(ProductInternalDto.Create dto) {
            return Product.builder()
                    .name(dto.name)
                    .price(dto.price)
                    .build();
        }

        public static ProductInternalDto.Create of(Product entity) {
            return ProductInternalDto.Create.builder()
                    .name(entity.getName())
                    .price(entity.getPrice())
                    .build();
        }
    }
}
