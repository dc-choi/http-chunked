package com.server.chucked.api.product.domain.persistence;

import com.server.chucked.api.product.domain.entity.Product;
import com.server.chucked.global.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void test() {
        // given
        Product product = Product.builder()
                .name("상품명")
                .price(1000L)
                .description("상품 설명")
                .build();
        // when
        productRepository.save(product);
        Product saved = productRepository.findById(product.getId())
                .orElseThrow(() -> BusinessException.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message("상품이 존재하지 않습니다.")
                        .build());
        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo(product.getId());
    }
}