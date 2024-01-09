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
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "1")
    private Integer departureAirportId;
    @NotNull
    @Schema(example = "2")
    private Integer arrivalAirportId;
    @NotNullDate
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
    @ValidPositiveBigDecimalValue
    @Schema(example = "200")
    private BigDecimal price;

}
