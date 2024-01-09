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
    private String departureAirport;
    private String arrivalAirport;
    @NotNullDate
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
}
