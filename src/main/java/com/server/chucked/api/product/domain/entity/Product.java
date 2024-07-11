package com.server.chucked.api.product.domain.entity;

import com.server.chucked.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
public class Product extends BaseEntity {
    @Comment("상품명")
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(200)")
    String name;

    @Comment("상품 가격")
    @Column(name = "price", nullable = true, columnDefinition = "BIGINT default 0")
    Long price;

    @Comment("상품 설명")
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    String description;
}
