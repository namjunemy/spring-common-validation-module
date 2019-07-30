package io.namjune.commonvalidation.exception;


import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;
    private List<FieldError> errors;
    private String code;

    public ErrorResponse(ErrorCode errorCode, List<FieldError> errors) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
        this.errors = errors;
    }

    @Getter
    @NoArgsConstructor
    public static class FieldError {

        private String objectName;
        private String field;
        private String defaultMessage;

        public FieldError(String objectName, String field, String defaultMessage) {
            this.objectName = objectName;
            this.field = field;
            this.defaultMessage = defaultMessage;
        }
    }
}
