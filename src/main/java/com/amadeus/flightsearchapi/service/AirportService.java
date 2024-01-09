/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.service
    FILE            : AirportService.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT INTERFACE : 

-----------------------------------------------------------------------*/
package com.amadeus.flightsearchapi.service;

import com.amadeus.flightsearchapi.dto.request.airport.AirportRequest;
import com.amadeus.flightsearchapi.dto.response.airport.AirportResponse;
import org.springframework.http.ResponseEntity;

public interface AirportService {
    ResponseEntity<AirportResponse> create(AirportRequest airportRequest);
    ResponseEntity<AirportResponse> update(AirportRequest airportRequest, Integer id);
    ResponseEntity<AirportResponse> read(Integer id);
    ResponseEntity<Void> delete(Integer id);
}
