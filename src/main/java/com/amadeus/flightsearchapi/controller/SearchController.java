

package com.amadeus.flightsearchapi.controller;

import com.amadeus.flightsearchapi.dto.request.flight.FlightSearchRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightResponse;
import com.amadeus.flightsearchapi.dto.response.flight.FlightSearchResponse;
import com.amadeus.flightsearchapi.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @PostMapping
    @Operation(summary = "Search flights", description = "Search flights with departure airport, arrival airport, departure date and incoming date if there is.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightResponse.class, type = "array")))
    public ResponseEntity<List<FlightSearchResponse>> searchFlights(@RequestBody @Valid FlightSearchRequest flightSearchRequest) {
        return searchService.searchFlights(flightSearchRequest);
    }


}
