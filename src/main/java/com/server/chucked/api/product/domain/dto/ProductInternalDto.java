package com.server.chucked.api.product.domain.dto;

import com.server.chucked.api.product.domain.entity.Product;
import lombok.Builder;

/**
 * 이 부분에 대한 처리를 어떻게 해야할 지 고민중...
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
