package io.namjune.commonvalidation.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MemberTypeValidator implements ConstraintValidator<MemberType, String> {

    @Override
    public void initialize(MemberType constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return io.namjune.commonvalidation.enums.MemberType.isMemberType(value);
    }
}
