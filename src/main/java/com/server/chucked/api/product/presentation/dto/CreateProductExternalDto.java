package com.server.chucked.api.product.presentation.dto;

import com.server.chucked.api.product.presentation.vaildation.CustomName;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public record CreateProductExternalDto() {
    public record Request(
            @NotNull(message = "name은 필수 값 입니다.")
            @CustomName
            String name,
            Long price
    ) {}

    @Builder
    public record Response(String name, Long price, String comment) {}
}
