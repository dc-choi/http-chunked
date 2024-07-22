package com.server.chucked.api.product.presentation.dto;

import com.server.chucked.api.product.presentation.vaildation.CustomName;
import jakarta.validation.constraints.NotNull;
import lombok.With;

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

    public record Response(ItemResponse item, MemberResponse member, String message) {}
    @With
    public record ItemResponse(String name, Long price, Long vat) {}
    public record MemberResponse(String email) {}
}
