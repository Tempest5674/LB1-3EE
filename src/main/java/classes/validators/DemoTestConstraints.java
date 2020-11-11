package classes.validators;

import classes.Car;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class DemoTestConstraints {
    private static final Validator validator;
    private static final javax.validation.Validation Validation = null;

    static {
        ValidatorFactory validatorFactory = javax.validation.Validation.buildDefaultValidatorFactory();
        validator = (Validator) validatorFactory.usingContext().getValidator();
    }

    @Test
    public void testValidators() {
        final Car car = new Car(0,"testModel",1,0);

        Set<ConstraintViolation<Car>> validates = validator.validate(car);
        Assert.assertTrue(validates.size() > 0);
        validates.stream().map(ConstraintViolation::getMessage)
                .forEach(System.out::println);
    }
}
