package com.server.chucked.api.product.presentation.dto;

import com.server.chucked.api.product.presentation.vaildation.CustomName;
import jakarta.validation.constraints.NotNull;

/**
 * Endpoint 1개당 DTO 1개
 */
public record CreateProductExternalDto() {
    public record Request(
            @NotNull(message = "name은 필수 값 입니다.")
            @CustomName
            String name,
            Long price
    ) {}

    public record Response(String name, Long price) {}
}
