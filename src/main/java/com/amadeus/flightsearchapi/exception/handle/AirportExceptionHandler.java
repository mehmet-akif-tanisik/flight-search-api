
package com.amadeus.flightsearchapi.exception.handle;

import com.amadeus.flightsearchapi.dto.response.ErrorResponse;
import com.amadeus.flightsearchapi.exception.AirportCreationException;
import com.amadeus.flightsearchapi.exception.AirportNotFoundException;
import com.amadeus.flightsearchapi.exception.AirportUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.logging.Logger;

import static com.amadeus.flightsearchapi.util.Constants.ERROR;

@ControllerAdvice
public class AirportExceptionHandler {
    private static final Logger logger =Logger.getLogger(AirportExceptionHandler.class.getName());

    @ExceptionHandler(AirportNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleAirportNotFoundException(AirportNotFoundException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false), e.getMessage(),null);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AirportCreationException.class)
    protected ResponseEntity<ErrorResponse> handleAirportCreationException(AirportCreationException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false), e.getMessage(),null);
        logger.severe(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AirportUpdateException.class)
    protected ResponseEntity<ErrorResponse> handleAirportUpdateException(AirportUpdateException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false), e.getMessage(),null);
        logger.severe(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
