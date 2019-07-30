package io.namjune.commonvalidation.exception;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = {Controller.class, RestController.class})
@RequiredArgsConstructor
public class ExceptionAdvice {

    @ExceptionHandler(ValidCustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse validCustomException(ValidCustomException ex) {
        return new ErrorResponse(ErrorCode.DUPLICATED_EMAIL, Collections.singletonList(ex.getFieldError()));
    }
}
