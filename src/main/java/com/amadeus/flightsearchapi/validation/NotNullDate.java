/*-----------------------------------------------------------------------
    PROJECT NAME    : heyworld-integration
    PACKAGE NAME    : com.solmaz.heyworldintegration.validation
    FILE            : NotEmptyLocalDateTime.java
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
import java.time.LocalDateTime;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface NotNullDate {
    String message() default "Departure date can not be null or empty.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class DateValidator implements ConstraintValidator<NotNullDate, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext context) {
        if (localDateTime==null || localDateTime.toString().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate( "Departure date can not be null or empty.").addConstraintViolation();
            return false;
        }
        return true;
    }
}
