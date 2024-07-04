package com.server.chucked.domain.test.dto;

import com.server.chucked.domain.test.vaild.CustomText;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestData {
    @NotNull(message = "id는 필수 값 입니다.")
    Long id;

    @NotNull(message = "name은 필수 값 입니다.")
    String name;

    @NotNull(message = "text는 필수 값 입니다.")
    @CustomText
    String text;
}
