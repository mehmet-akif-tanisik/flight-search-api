/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.dto.response
    FILE            : AirportResponse.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

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
