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
import com.amadeus.flightsearchapi.dto.response.ErrorResponse;
import com.amadeus.flightsearchapi.dto.response.airport.AirportResponse;
import com.amadeus.flightsearchapi.service.AirportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Save airport", description = "Save airport with city name.")
    @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AirportResponse.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<AirportResponse> create(@RequestBody @Valid AirportRequest airportRequest) {
        return airportService.create(airportRequest);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get airport", description = "Get airport with airport id.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AirportResponse.class)))
    @ApiResponse(responseCode = "404", description = "Airport doest not exists.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<AirportResponse> read(@PathVariable Integer id) {
        return airportService.read(id);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update airport", description = "Update airport with airport id and city name.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AirportResponse.class)))
    @ApiResponse(responseCode = "404", description = "Airport doest not exists", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<AirportResponse> update(@RequestBody @Valid AirportRequest airportRequest, @PathVariable Integer id) {
        return airportService.update(airportRequest, id);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete airport", description = "Delete airport with airport id.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "404", description = "Airport doest not exists", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return airportService.delete(id);
    }
}
