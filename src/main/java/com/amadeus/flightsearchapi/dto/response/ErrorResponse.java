/*-----------------------------------------------------------------------
    PROJECT NAME    : cia-salesforceintegration
    PACKAGE NAME    : com.solmaz.ciasalesforceintegration.dto.response
    FILE            : ErrorResponse.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.http.HttpStatus;

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
