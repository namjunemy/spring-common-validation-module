package io.namjune.commonvalidation.exception;


import io.namjune.commonvalidation.exception.ErrorResponse.FieldError;
import lombok.Getter;

/**
 * 커스텀 Valid Exception 선언
 */
@Getter
public class ValidCustomException extends RuntimeException {

    private FieldError fieldError;

    public ValidCustomException(FieldError fieldError) {
        this.fieldError = fieldError;
    }
}
