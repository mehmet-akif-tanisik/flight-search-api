/*-----------------------------------------------------------------------
    PROJECT NAME    : cia-salesforceintegration
    PACKAGE NAME    : com.solmaz.ciasalesforceintegration.util
    FILE            : ValidTCKNAndTaxNo.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT ANNOTATION: 

-----------------------------------------------------------------------*/
package com.amadeus.flightsearchapi.validation;


import com.amadeus.flightsearchapi.dto.request.flight.FlightRequest;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepartureAndReturnDateValidator.class)
public @interface ValidateDepartureAndReturnDate {
    String message() default "Departure day and time cannot be earlier than arrival day and time.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class DepartureAndReturnDateValidator implements ConstraintValidator<ValidateDepartureAndReturnDate, FlightRequest> {
    @Override
    public boolean isValid(FlightRequest value, ConstraintValidatorContext context) {
        if (value.getReturnDateTime()!=null && value.getDepartureDateTime()!=null){
            LocalDateTime departureDateTime = value.getDepartureDateTime();
            LocalDateTime arrivalDateTime = value.getReturnDateTime();
            if (!departureDateTime.isBefore(arrivalDateTime)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Departure day and time cannot be earlier than arrival day and time.")
                        .addPropertyNode("departureDateTime").addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}
