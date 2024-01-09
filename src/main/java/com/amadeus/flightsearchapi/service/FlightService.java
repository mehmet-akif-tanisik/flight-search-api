
package com.amadeus.flightsearchapi.service;

import com.amadeus.flightsearchapi.dto.request.flight.FlightRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightResponse;
import org.springframework.http.ResponseEntity;

public interface FlightService {
    ResponseEntity<FlightResponse> create(FlightRequest flightRequest);
    ResponseEntity<FlightResponse> read(Long id);
    ResponseEntity<FlightResponse> update(FlightRequest flightRequest, Long id);
    ResponseEntity<Void> delete(Long id);
}
