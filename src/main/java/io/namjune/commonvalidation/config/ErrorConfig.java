package io.namjune.commonvalidation.config;

import io.namjune.commonvalidation.exception.ValidCustomException;
import java.util.Map;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Configuration
public class ErrorConfig {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {

            public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes,
                boolean includeStackTrace) {
                Map<String, Object> errorAttributes = super
                    .getErrorAttributes((WebRequest) requestAttributes, includeStackTrace);
                Throwable error = getError((WebRequest) requestAttributes);
                if (error instanceof ValidCustomException) {
                    errorAttributes.put("errors", ((ValidCustomException) error).getErrors());
                }

                return errorAttributes;
            }
        };
    }
}
