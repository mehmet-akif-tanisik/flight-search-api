

package com.amadeus.flightsearchapi.service.implementation;

import com.amadeus.flightsearchapi.dto.request.flight.FlightSearchRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightSearchResponse;
import com.amadeus.flightsearchapi.entity.Flight;
import com.amadeus.flightsearchapi.repository.FlightRepository;
import com.amadeus.flightsearchapi.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<List<FlightSearchResponse>> searchFlights(FlightSearchRequest flightSearchRequest) {

        List<Flight> searchResults = new ArrayList<>();

        if (flightSearchRequest.getReturnDateTime()==null){

            searchResults.addAll(getOneWayFlights(flightSearchRequest.getDepartureAirport(),
                    flightSearchRequest.getArrivalAirport(),
                    flightSearchRequest.getDepartureDateTime()));

            List<FlightSearchResponse> flightResultsResponses = searchResults.stream().map( flight -> modelMapper.map(flight, FlightSearchResponse.class)).toList();

            return new ResponseEntity<>(flightResultsResponses, HttpStatus.OK);
        } else {

            searchResults.addAll(getOneWayFlights(flightSearchRequest.getDepartureAirport(),
                    flightSearchRequest.getArrivalAirport(),flightSearchRequest.getDepartureDateTime()));
            searchResults.addAll(getOneWayFlights(flightSearchRequest.getArrivalAirport(),
                    flightSearchRequest.getDepartureAirport(),flightSearchRequest.getReturnDateTime()));

            List<FlightSearchResponse> flightResultsResponses = searchResults.stream().map( flight -> modelMapper.map(flight, FlightSearchResponse.class)).toList();

            return new ResponseEntity<>(flightResultsResponses, HttpStatus.OK);
        }
    }

    private List<Flight> getOneWayFlights(String departureCity, String arrivalCity, LocalDateTime departureDateTime) {
        return flightRepository.findFlightsByDepartureAirport_CityAndAndArrivalAirport_CityAndDepartureDateTimeAfter(departureCity,arrivalCity,departureDateTime);
    }
}
