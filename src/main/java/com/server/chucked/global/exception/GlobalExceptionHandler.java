package com.server.chucked.global.exception;

import com.server.chucked.global.common.response.ErrorResponse;
import com.server.chucked.global.common.response.HttpMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.AccountExpiredException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Custom Exception Handler
     */
    @ExceptionHandler({
            BusinessException.class,
            ValidationException.class // Custom Validation Exception
    })
    public ResponseEntity<ErrorResponse> handlerBusinessException(BusinessException e, HttpServletRequest request) {
        return ResponseEntity
                .status(e.getStatus())
                .body(ErrorResponse.of(
                        e.getMessage(),
                        request
                ));
    }

    /**
     * Validation 관련 Exception Handler
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleBindException(MethodArgumentNotValidException e, HttpServletRequest request) {
       StringBuilder message = new StringBuilder();

        e.getFieldErrors().forEach(fieldError -> {
            message.append(fieldError.getDefaultMessage()).append(',');
        });
        message.deleteCharAt(message.length() - 1); // 마지막 ',' 제거

        return ResponseEntity
                .status(HttpMessage.Fail.INVALID_INPUT_VALUE.getStatus())
                .body(ErrorResponse.of(
                        message.toString(),
                        request
                ));
    }

    /**
     * HTTP 관련 Exception Handler
     */
    @ExceptionHandler({
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class,
            AccessDeniedException.class
    })
    public ResponseEntity<ErrorResponse> handleHttpException(Exception e, HttpServletRequest request) {
        HttpMessage.Fail response;

        String exceptionName = e.getClass().getSimpleName();
        switch (exceptionName) {
            case "HttpRequestMethodNotSupportedException" -> response = HttpMessage.Fail.METHOD_NOT_ALLOWED;
            case "AccessDeniedException" -> response = HttpMessage.Fail.DEACTIVATE_USER;
            case "MissingServletRequestParameterException" -> response = HttpMessage.Fail.MISSING_PARAMETER;
            default -> response = HttpMessage.Fail.BAD_REQUEST;
        }

        return ResponseEntity
                .status(response.getStatus())
                .body(ErrorResponse.of(
                        response.getMessage(),
                        request
                ));
    }

    /**
     * Security 관련 Exception Handler
     */
    @ExceptionHandler({
            AccountExpiredException.class,
//            AccountStatusException.class,
//            AuthenticationCredentialsNotFoundException.class,
//            AuthenticationServiceException.class,
//            BadCredentialsException.class,
//            CredentialsExpiredException.class,
//            OAuth2AuthenticationException.class,
//            UsernameNotFoundException.class
    })
    public ResponseEntity<ErrorResponse> handleSecurityException(Exception e, HttpServletRequest request) {
        HttpMessage.Fail response;

        String exceptionName = e.getClass().getSimpleName();
        switch (exceptionName) {
            case "AuthenticationCredentialsNotFoundException", "BadCredentialsException" ->
                    response = HttpMessage.Fail.INVALID_TOKEN;
            case "AccountExpiredException", "CredentialsExpiredException" -> response = HttpMessage.Fail.EXPIRED_TOKEN;
            case "AccountStatusException", "OAuth2AuthenticationException", "UsernameNotFoundException" ->
                    response = HttpMessage.Fail.INVALID_ACCOUNT;
            default -> response = HttpMessage.Fail.UNAUTHORIZED;
        }

        return ResponseEntity
                .status(response.getStatus())
                .body(ErrorResponse.of(
                        response.getMessage(),
                        request
                ));
    }

    /**
     * 설정하지 않은 Exception 처리 Handler
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerAllException(Exception e, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpMessage.Fail.INTERNAL_SERVER_ERROR.getStatus())
                .body(ErrorResponse.of(
                        HttpMessage.Fail.INTERNAL_SERVER_ERROR.getMessage(),
                        request,
                        e
                ));
    }
}
