package com.server.chucked.api.product.application.event;

import lombok.Builder;

@Builder
public record CreateProductEvent(String type, String message) {}
