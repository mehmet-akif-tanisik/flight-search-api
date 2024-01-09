/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.controller
    FILE            : FlightController.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.controller;

import com.amadeus.flightsearchapi.dto.request.flight.FlightRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightResponse;
import com.amadeus.flightsearchapi.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    @PostMapping
    public ResponseEntity<FlightResponse> create(@RequestBody @Valid FlightRequest flightRequest) {
        return flightService.create(flightRequest);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> read(@PathVariable Long id) {
        return flightService.read(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FlightResponse> update(@RequestBody @Valid FlightRequest flightRequest, @PathVariable Long id) {
        return flightService.update(flightRequest, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return flightService.delete(id);
    }
}
