

package com.amadeus.flightsearchapi.exception.handle;

import com.amadeus.flightsearchapi.dto.response.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

import static com.amadeus.flightsearchapi.util.Constants.ERROR;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false),"Validation failed for argument(s)",errorMap);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e, WebRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        e.getConstraintViolations().forEach(violation -> {
            String propertyPath = getLastNode(violation.getPropertyPath().toString());
            String message = violation.getMessage();
            errorMap.put(propertyPath, message);
        });
        ErrorResponse response = new ErrorResponse(ERROR, request.getDescription(false),"Validation failed for argument(s)",errorMap);
        return new ResponseEntity<>(response , HttpStatus.BAD_REQUEST);
    }
    private String getLastNode(String propertyPath) {
        if (propertyPath==null) {
            return "";
        } else {
            String[] parts = propertyPath.split("\\.");
            return parts[parts.length - 1];
        }
    }
}
