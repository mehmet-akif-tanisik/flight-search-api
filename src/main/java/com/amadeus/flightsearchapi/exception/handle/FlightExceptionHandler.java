/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.exception.handle
    FILE            : FlightExceptionHandler.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.exception.handle;

import com.amadeus.flightsearchapi.dto.response.ErrorResponse;
import com.amadeus.flightsearchapi.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.logging.Logger;

import static com.amadeus.flightsearchapi.util.Constants.ERROR;

@ControllerAdvice
public class FlightExceptionHandler {
    private static final Logger logger = Logger.getLogger(FlightExceptionHandler.class.getName());

    @ExceptionHandler(FlightNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleFlightNotFoundException(FlightNotFoundException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false), e.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FlightCreationException.class)
    protected ResponseEntity<ErrorResponse> handleFlightCreationException(FlightCreationException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false), e.getMessage(),null);
        logger.severe(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlightUpdateException.class)
    protected ResponseEntity<ErrorResponse> handleFlightUpdateException(FlightUpdateException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false), e.getMessage(),null);
        logger.severe(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
