package com.server.chucked.api.product.presentation.vaildation;

import com.server.chucked.global.common.response.HttpMessage;
import com.server.chucked.global.exception.BusinessException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class CustomNameValidator implements ConstraintValidator<CustomName, String> {
    @Override
    public void initialize(CustomName annotation) {
        ConstraintValidator.super.initialize(annotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;

        /**
         * null 값은 별도의 @NotNull 어노테이션으로 처리해야 합니다.
         * null을 허용하게 되면 아래 로직에서 NPE가 발생합니다.
         */
        if (value == null) {
            return valid;
        }

        List<String> messages = new ArrayList<>();

        if (value.isEmpty() || value.isBlank()) {
            messages.add(HttpMessage.Fail.NOT_BLANK.getMessage());

            valid = false;
        }

        // Size 검증
        if (value.length() > 15) {
            messages.add(HttpMessage.Fail.TEXT_MAX_LENGTH.getMessage());

            valid = false;
        }

        // Pattern 검증 1: 특수문자 검증
        String specialCharsPattern = "[가-힣a-zA-Z0-9()\\[\\]+\\-&/_]*$";
        if (!value.matches(specialCharsPattern)) {
            messages.add(HttpMessage.Fail.TEXT_NOT_SPECIAL.getMessage());

            valid = false;
        }

        // Pattern 검증 2: "카카오" 포함 여부 검증
        String kakaoPattern = "^(?!.*카카오).*$";
        if (!value.matches(kakaoPattern)) {
            messages.add(HttpMessage.Fail.TEXT_NOT_KAKAO.getMessage());

            valid = false;
        }

        if (!valid) {
            throw BusinessException.builder()
                    .status(HttpMessage.Fail.INVALID_INPUT_VALUE.getStatus())
                    .message(String.join(", ", messages))
                    .build();
        }

        return true;
    }
}
