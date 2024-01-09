/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.service.implementation
    FILE            : FlightServiceImpl.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.service.implementation;

import com.amadeus.flightsearchapi.dto.request.flight.FlightRequest;
import com.amadeus.flightsearchapi.dto.response.flight.FlightResponse;
import com.amadeus.flightsearchapi.entity.Airport;
import com.amadeus.flightsearchapi.entity.Flight;
import com.amadeus.flightsearchapi.exception.*;
import com.amadeus.flightsearchapi.repository.AirportRepository;
import com.amadeus.flightsearchapi.repository.FlightRepository;
import com.amadeus.flightsearchapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;
    private static final Logger logger =Logger.getLogger(FlightServiceImpl.class.getName());
    @Override
    public ResponseEntity<FlightResponse> create(FlightRequest flightRequest) {

        try {
            Flight flight = new Flight();

            Airport departureAirport = getAirportById(flightRequest.getDepartureAirportId());
            Airport arrivalAirport = getAirportById(flightRequest.getArrivalAirportId());

            flight.setPrice(flightRequest.getPrice());
            flight.setDepartureDateTime(flightRequest.getDepartureDateTime());
            flight.setReturnDateTime(flightRequest.getReturnDateTime());
            flight.setDepartureAirport(departureAirport);
            flight.setArrivalAirport(arrivalAirport);

            Flight savedFlight = flightRepository.save(flight);

            FlightResponse response = modelMapper.map(savedFlight, FlightResponse.class);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (AirportNotFoundException e){
            throw new AirportNotFoundException("Airport does not exists.");
        }
        catch (RuntimeException e) {
            logger.severe("Flight could not be saved due to error: " + e.getMessage());
            throw new FlightCreationException("Airport could not be saved.");
        }
    }
    @Override
    public ResponseEntity<FlightResponse> read(Long id) {
        Flight flight = getFlightById(id);
        FlightResponse response = modelMapper.map(flight, FlightResponse.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<FlightResponse> update(FlightRequest flightRequest, Long id) {
        try {
            Flight flight = getFlightById(id);

            Airport departureAirport = getAirportById(flightRequest.getDepartureAirportId());
            Airport arrivalAirport = getAirportById(flightRequest.getArrivalAirportId());

            flight.setDepartureAirport(departureAirport);
            flight.setArrivalAirport(arrivalAirport);
            flight.setDepartureDateTime(flightRequest.getDepartureDateTime());
            flight.setReturnDateTime(flightRequest.getReturnDateTime());
            flight.setPrice(flightRequest.getPrice());

            Flight updatedFlight = flightRepository.save(flight);

            FlightResponse response = modelMapper.map(updatedFlight, FlightResponse.class);

            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (FlightNotFoundException e){
            throw new FlightNotFoundException("Flight does not exists.");
        }catch (AirportNotFoundException e){
            throw new AirportNotFoundException("Airport does not exists.");
        } catch (RuntimeException e) {
            logger.severe("Flight could not be updated due to error: " + e.getMessage());
            throw new FlightUpdateException("Flight could not be updated.");
        }
    }
    @Override
    public ResponseEntity<Void> delete(Long id) {
        Flight flightToBeDeleted = getFlightById(id);
        flightRepository.delete(flightToBeDeleted);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private Airport getAirportById(Integer id) {
        return airportRepository.findById(id).orElseThrow( () -> new AirportNotFoundException("Airport doest not exist."));
    }
    private Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow( () -> new FlightNotFoundException("Flight doest not exist."));
    }
}
