/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.dto.request.flight
    FILE            : FlightRequest.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT RECORD    : 

-----------------------------------------------------------------------*/
package com.amadeus.flightsearchapi.dto.request.flight;

import com.amadeus.flightsearchapi.validation.NotNullDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class FlightSearchRequest {
    @Schema(example = "Istanbul")
    private String departureAirport;
    @Schema(example = "New York")
    private String arrivalAirport;
    @NotNullDate
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
}
