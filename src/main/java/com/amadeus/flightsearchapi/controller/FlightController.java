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
import com.amadeus.flightsearchapi.dto.response.ErrorResponse;
import com.amadeus.flightsearchapi.dto.response.airport.AirportResponse;
import com.amadeus.flightsearchapi.dto.response.flight.FlightResponse;
import com.amadeus.flightsearchapi.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Save flight", description = "Save flight with city name.")
    @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightResponse.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<FlightResponse> create(@RequestBody @Valid FlightRequest flightRequest) {
        return flightService.create(flightRequest);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get flight", description = "Get flight with flight id.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightResponse.class)))
    @ApiResponse(responseCode = "404", description = "flight doest not exists.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<FlightResponse> read(@PathVariable Long id) {
        return flightService.read(id);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update flight", description = "Update flight with flight id and flight information's.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightResponse.class)))
    @ApiResponse(responseCode = "404", description = "Flight doest not exists", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<FlightResponse> update(@RequestBody @Valid FlightRequest flightRequest, @PathVariable Long id) {
        return flightService.update(flightRequest, id);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete flight", description = "Delete flight with flight id.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "404", description = "Flight doest not exists", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return flightService.delete(id);
    }
}
