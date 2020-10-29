package com.spring.cinema.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {
    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch valueMatch) {
        this.field = valueMatch.field();
        this.fieldMatch = valueMatch.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext validatorContext) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
        return fieldValue != null ? fieldValue.equals(fieldMatchValue) : fieldMatchValue == null;
    }
}
