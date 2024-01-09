/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.service.implementation
    FILE            : SearchServiceImpl.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.service.implementation;

import com.amadeus.flightsearchapi.dto.request.flight.FlightSearchRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightResponse;
import com.amadeus.flightsearchapi.entity.Flight;
import com.amadeus.flightsearchapi.repository.FlightRepository;
import com.amadeus.flightsearchapi.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<List<FlightResponse>> searchFlights(FlightSearchRequest flightSearchRequest) {

        if (flightSearchRequest.getReturnDateTime()==null){
            List<Flight> flightResults = getOneWayFlights(flightSearchRequest.getDepartureAirport(),
                    flightSearchRequest.getArrivalAirport(),
                    flightSearchRequest.getDepartureDateTime());

            List<FlightResponse> flightResultsResponses = flightResults.stream().map( flight -> modelMapper.map(flight, FlightResponse.class)).toList();

            return new ResponseEntity<>(flightResultsResponses, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    private List<Flight> getOneWayFlights(String departureCity, String arrivalCity, LocalDateTime departureDateTime) {
        return flightRepository.findFlightsByDepartureAirport_CityAndAndArrivalAirport_CityAndDepartureDateTimeAfter(departureCity,arrivalCity,departureDateTime);
    }
}
