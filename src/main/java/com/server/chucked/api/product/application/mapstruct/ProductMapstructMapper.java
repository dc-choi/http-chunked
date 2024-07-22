package com.server.chucked.api.product.application.mapstruct;

import com.server.chucked.api.member.domain.dto.MemberInternalDto;
import com.server.chucked.api.product.domain.dto.ProductInternalDto;
import com.server.chucked.api.product.presentation.dto.CreateProductExternalDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductMapstructMapper {
    // External DTO 와 Internal DTO 가 서로 다른 구조를 가지고 있을 때
    @Mapping(expression = "java(new ItemResponse(response.name(), response.price(), vat))", target = "item")
    // External DTO 와 Internal DTO 가 서로 같은 구조를 가지고 있을 때
    @Mapping(source = "member", target = "member")
    CreateProductExternalDto.Response of(ProductInternalDto.Create response, MemberInternalDto.Create member, Long vat, String message);
    ProductInternalDto.Create of(CreateProductExternalDto.Request request);
}
