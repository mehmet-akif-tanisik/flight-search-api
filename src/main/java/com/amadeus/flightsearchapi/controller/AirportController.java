/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.controller
    FILE            : AirportController.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.controller;

import com.amadeus.flightsearchapi.dto.request.airport.AirportRequest;
import com.amadeus.flightsearchapi.dto.response.airport.AirportResponse;
import com.amadeus.flightsearchapi.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;
    @PostMapping
    public ResponseEntity<AirportResponse> create(@RequestBody @Valid AirportRequest airportRequest) {
        return airportService.create(airportRequest);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> read(@PathVariable Integer id) {
        return airportService.read(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> update(@RequestBody @Valid AirportRequest airportRequest, @PathVariable Integer id) {
        return airportService.update(airportRequest, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return airportService.delete(id);
    }
}
