package interfaces;


import classes.validators.CarSeatsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= CarSeatsConstraintValidator.class)
public @interface CarSeatsConstraint {
    String message() default "Car seats must be >= 2";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
