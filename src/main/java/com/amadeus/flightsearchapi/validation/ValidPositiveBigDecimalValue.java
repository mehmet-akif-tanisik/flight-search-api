/*-----------------------------------------------------------------------
    PROJECT NAME    : heyworld-integration
    PACKAGE NAME    : com.solmaz.heyworldintegration.validation
    FILE            : ValidCountryCode.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT ANNOTATION: 

-----------------------------------------------------------------------*/
package com.amadeus.flightsearchapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositiveBigDecimalValueValidator.class)
public @interface ValidPositiveBigDecimalValue {
    String message() default "Value should be greater than zero.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class PositiveBigDecimalValueValidator implements ConstraintValidator<ValidPositiveBigDecimalValue, BigDecimal> {
    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (value!=null){
            return value.compareTo(BigDecimal.ZERO) > 0;
        }
        return false;
    }
}
