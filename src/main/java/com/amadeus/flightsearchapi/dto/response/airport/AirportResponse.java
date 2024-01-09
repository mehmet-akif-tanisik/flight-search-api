

package com.amadeus.flightsearchapi.dto.response.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportResponse {
    private Integer id;
    private String city;
}
