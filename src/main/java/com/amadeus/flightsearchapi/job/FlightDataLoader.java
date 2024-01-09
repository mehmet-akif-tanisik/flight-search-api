/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.job
    FILE            : FlightDataLoader.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.job;

import com.amadeus.flightsearchapi.entity.Airport;
import com.amadeus.flightsearchapi.entity.Flight;
import com.amadeus.flightsearchapi.repository.AirportRepository;
import com.amadeus.flightsearchapi.repository.FlightRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Component
public class FlightDataLoader {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final Resource mockDataResource;
    private final Resource mockAirportResource;
    private final ObjectMapper objectMapper;
    private static final Logger logger = Logger.getLogger(FlightDataLoader.class.getName());

    public FlightDataLoader(FlightRepository flightRepository,
                            AirportRepository airportRepository, @Value("classpath:data/mockFlights.json") Resource mockDataResource,
                            @Value("classpath:data/mockAirports.json") Resource mockAirportResource,
                            ObjectMapper objectMapper) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.mockDataResource = mockDataResource;
        this.mockAirportResource = mockAirportResource;
        this.objectMapper = objectMapper;
    }

    public void sendApiRequestToGetFlightData() {
        try {
            List<Airport> mockAirports = objectMapper.readValue(
                    mockAirportResource.getInputStream(),
                    new TypeReference<List<Airport>>() {
                    }
            );
            List<Flight> mockFlights = objectMapper.readValue(
                    mockDataResource.getInputStream(),
                    new TypeReference<List<Flight>>() {
                    }
            );
            airportRepository.saveAll(mockAirports);
            flightRepository.saveAll(mockFlights);

            logger.info("Mock flights loaded to the database at: " + LocalDateTime.now());
        } catch (IOException e) {
            logger.info("Failed to load mock flight data: " + e.getMessage());
        }
    }
}

