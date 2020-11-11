package classes.validators;

import interfaces.CarSeatsConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarSeatsConstraintValidator implements ConstraintValidator<CarSeatsConstraint,Integer> {

    @Override
    public boolean isValid(Integer seats, ConstraintValidatorContext constraintValidatorContext) {
        return seats>=2;
    }
}
