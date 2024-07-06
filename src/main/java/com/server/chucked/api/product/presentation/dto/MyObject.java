package com.server.chucked.api.product.presentation.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class MyObject {
    private String name;
    private Integer ages;
}