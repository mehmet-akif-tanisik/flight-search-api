
package com.amadeus.flightsearchapi.service;

import com.amadeus.flightsearchapi.dto.request.flight.FlightSearchRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightSearchResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchService {
    ResponseEntity<List<FlightSearchResponse>> searchFlights(FlightSearchRequest flightSearchRequest);
}
