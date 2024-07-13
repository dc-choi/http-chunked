package com.server.chucked.api.product.presentation.dto;

public record FindAllProductExternalDto() {
    public record Response(String name, Long price) {}
}
