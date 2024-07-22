package com.server.chucked.api.product.application;

import com.server.chucked.api.member.domain.dto.MemberInternalDto;
import com.server.chucked.api.product.application.event.CreateProductEvent;
import com.server.chucked.api.product.application.mapstruct.ProductMapstructMapper;
import com.server.chucked.api.product.domain.ProductProcessor;
import com.server.chucked.api.product.domain.dto.ProductInternalDto;
import com.server.chucked.api.product.domain.entity.Product;
import com.server.chucked.api.product.presentation.dto.CreateProductExternalDto;
import com.server.chucked.global.common.Events;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductMapstructMapper productMapstructMapper;
    private final ProductProcessor productProcessor;

    public Page<Product> findAll(Pageable pageable) {
        return productProcessor.findAll(pageable);
    }

    @Transactional
    public CreateProductExternalDto.Response create(final CreateProductExternalDto.Request request) {
        ProductInternalDto.Create dto = productMapstructMapper.of(request);

        ProductInternalDto.Create created = productProcessor.create(dto);

        String message = created.name() + "이 생성되었습니다.";

        Events.raise(CreateProductEvent.builder()
                .type("Product")
                .message(message)
                .build());

        MemberInternalDto.Create memberDto = MemberInternalDto.Create.builder()
                .email("email")
                .build();

        return productMapstructMapper.of(created, memberDto, 1L, message);
    }
}
