package com.chmykhun.validation;


import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.util.ValidatorUtils;

public class ValidationRules {

    private static final String PHONE_NUMBER_REGEX = "\\+380\\d{9}";

    public static boolean validateRequired(Object bean, Field field) {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        return !GenericValidator.isBlankOrNull(value);
    }

    public static boolean validatePhoneNumber(Object bean, Field field){
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        return GenericValidator.matchRegexp(value, PHONE_NUMBER_REGEX);
    }

}
