package pl.com.sages.spring.bootcamp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CurrencyValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Currency {

    double maxValue() default 10_000;

    String message() default "Invalid price value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
