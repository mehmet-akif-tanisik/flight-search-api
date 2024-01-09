/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.controller
    FILE            : SearchController.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.controller;

import com.amadeus.flightsearchapi.dto.request.flight.FlightSearchRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightResponse;
import com.amadeus.flightsearchapi.service.SearchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @PostMapping
    public ResponseEntity<List<FlightResponse>> searchFlights(@RequestBody @Valid FlightSearchRequest flightSearchRequest) {
        return searchService.searchFlights(flightSearchRequest);
    }


}
