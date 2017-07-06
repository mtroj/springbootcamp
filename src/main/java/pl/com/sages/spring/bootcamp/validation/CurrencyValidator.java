package pl.com.sages.spring.bootcamp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrencyValidator implements ConstraintValidator<Currency, Double> {

    private double maxValue;

    @Override
    public void initialize(Currency constraintAnnotation) {
        maxValue = constraintAnnotation.maxValue();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value < maxValue;
    }

}
