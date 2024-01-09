
package com.amadeus.flightsearchapi.dto.request.airport;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AirportRequest {
    @Size(max = 50)
    @Schema(example = "Istanbul")
    private String city;
}
