package com.server.chucked.global.exception;

import com.server.chucked.global.common.response.HttpMessage;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class BusinessException extends RuntimeException {
    private HttpStatus status;
    private String message;

    @Builder
    public BusinessException(HttpMessage.Fail response) {
        super(response.getMessage());
        this.status = response.getStatus();
        this.message = response.getMessage();
    }
}
