package com.server.chucked.api.product.application.mapstruct;

import com.server.chucked.api.product.domain.dto.ProductInternalDto;
import com.server.chucked.api.product.presentation.dto.CreateProductExternalDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductMapstructMapper {
    ProductInternalDto.Create of(CreateProductExternalDto.Request request);
    CreateProductExternalDto.Response of(ProductInternalDto.Create response);
}
