package io.namjune.commonvalidation.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 커스텀 Valid Exception 선언
 */
@Getter
public class ValidCustomException extends RuntimeException {

    private Error[] errors;

    public ValidCustomException(String defaultMessage, String field) {
        this.errors = new Error[]{new Error(defaultMessage, field)};
    }

    public ValidCustomException(Error[] errors) {
        this.errors = errors;
    }

    @Getter
    public static class Error {

        private String defaultMessage;
        private String field;

        public Error(String defaultMessage, String field) {
            this.defaultMessage = defaultMessage;
            this.field = field;
        }
    }
}
