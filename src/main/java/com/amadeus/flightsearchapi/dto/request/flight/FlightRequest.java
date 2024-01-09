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
import com.amadeus.flightsearchapi.validation.ValidPositiveBigDecimalValue;
import com.amadeus.flightsearchapi.validation.ValidateDepartureAndArrivalAirports;
import com.amadeus.flightsearchapi.validation.ValidateDepartureAndReturnDate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@ValidateDepartureAndReturnDate
@ValidateDepartureAndArrivalAirports
public class FlightRequest{
    @NotNull
    private Integer departureAirportId;
    @NotNull
    private Integer arrivalAirportId;
    @NotNullDate
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
    @ValidPositiveBigDecimalValue
    private BigDecimal price;

}
