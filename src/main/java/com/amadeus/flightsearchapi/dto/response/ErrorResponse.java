

package com.amadeus.flightsearchapi.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String status;
    private String message;
    private Map<String, String> fields;
    private String path;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime  timestamp ;

    public ErrorResponse(String status, String path,
                         String message, Map<String, String> fields) {
        this.status = status;
        this.path = path;
        this.message = message;
        timestamp = LocalDateTime.now();
        this.fields = fields;
    }
}
