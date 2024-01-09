
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

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepartureAndArrivalAirportsValidator.class)
public @interface ValidateDepartureAndArrivalAirports {
    String message() default "Departure airport and Arrival airport can not be same.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class DepartureAndArrivalAirportsValidator implements ConstraintValidator<ValidateDepartureAndArrivalAirports, FlightRequest> {
    @Override
    public boolean isValid(FlightRequest value, ConstraintValidatorContext context) {
        Integer departureAirportId = value.getDepartureAirportId();
        Integer arrivalAirportId = value.getArrivalAirportId();

        if (departureAirportId.compareTo(arrivalAirportId) == 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Departure airport and Arrival airport can not be same.")
                    .addPropertyNode("departureAirportId").addConstraintViolation();
            return false;
        }
        return true;
    }
}
