package com.server.chucked.domain.test.vaild;

import com.server.chucked.global.common.response.HttpResponse;
import com.server.chucked.global.exception.BusinessException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomTextValidator implements ConstraintValidator<CustomText, String> {
    @Override
    public void initialize(CustomText annotation) {
        ConstraintValidator.super.initialize(annotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;

        if (value == null) {
            return valid; // null 값은 별도의 @NotNull 어노테이션으로 처리해야 합니다.
        }

        List<String> messages = new ArrayList<>();

        if (value.isEmpty() || value.isBlank()) {
            messages.add(HttpResponse.Fail.NOT_BLANK.getMessage());

            valid = false;
        }

        // Size 검증
        if (value.length() > 15) {
            messages.add(HttpResponse.Fail.TEXT_MAX_LENGTH.getMessage());

            valid = false;
        }

        // Pattern 검증 1: 특수문자 검증
        String specialCharsPattern = "[a-zA-Z0-9()\\[\\]+\\-&/_]*$";
        if (!value.matches(specialCharsPattern)) {
            messages.add(HttpResponse.Fail.TEXT_NOT_SPECIAL.getMessage());

            valid = false;
        }

        // Pattern 검증 2: "카카오" 포함 여부 검증
        String kakaoPattern = "^(?!.*카카오).*$";
        if (!value.matches(kakaoPattern)) {
            messages.add(HttpResponse.Fail.TEXT_NOT_KAKAO.getMessage());

            valid = false;
        }

        if (!valid) {
            throw BusinessException.builder()
                    .status(HttpResponse.Fail.INVALID_INPUT_VALUE.getStatus())
                    .message(String.join(", ", messages))
                    .build();
        }

        return true;
    }
}
