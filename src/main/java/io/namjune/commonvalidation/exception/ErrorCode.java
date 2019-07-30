package io.namjune.commonvalidation.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    DUPLICATED_EMAIL(400, "V001", "Duplicated email");

    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
