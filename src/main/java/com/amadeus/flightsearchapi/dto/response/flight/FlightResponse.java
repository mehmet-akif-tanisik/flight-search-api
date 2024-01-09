

package com.amadeus.flightsearchapi.dto.response.flight;

import com.amadeus.flightsearchapi.dto.response.airport.AirportResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {
    private Long id;
    private AirportResponse departureAirport;
    private AirportResponse arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
    private BigDecimal price;
}
