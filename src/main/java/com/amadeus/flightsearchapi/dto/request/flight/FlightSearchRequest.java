
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
