

package com.amadeus.flightsearchapi.service.implementation;

import com.amadeus.flightsearchapi.dto.request.airport.AirportRequest;
import com.amadeus.flightsearchapi.dto.response.airport.AirportResponse;
import com.amadeus.flightsearchapi.entity.Airport;
import com.amadeus.flightsearchapi.exception.AirportCreationException;
import com.amadeus.flightsearchapi.exception.AirportNotFoundException;
import com.amadeus.flightsearchapi.exception.AirportUpdateException;
import com.amadeus.flightsearchapi.repository.AirportRepository;
import com.amadeus.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;
    private static final Logger logger =Logger.getLogger(AirportServiceImpl.class.getName());
    @Override
    public ResponseEntity<AirportResponse> create(AirportRequest airportRequest) {
        try {
            Airport airport = new Airport();
            airport.setCity(airportRequest.getCity());

            Airport savedAirport = airportRepository.save(airport);

            AirportResponse response = modelMapper.map(savedAirport, AirportResponse.class);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            logger.severe("Airport could not be saved due to error: " + e.getMessage());
            throw new AirportCreationException("Airport could not be saved.");
        }
    }

    @Override
    public ResponseEntity<AirportResponse> read(Integer id) {
        Airport airport = getAirportById(id);
        AirportResponse response = new AirportResponse(airport.getId(), airport.getCity());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AirportResponse> update(AirportRequest airportRequest, Integer id) {
        try {
            Airport airport = getAirportById(id);

            airport.setCity(airportRequest.getCity());

            Airport updatedAirport = airportRepository.save(airport);

            AirportResponse response = modelMapper.map(updatedAirport, AirportResponse.class);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AirportNotFoundException e){
            throw new AirportNotFoundException("Airport does not exists.");
        }
        catch (RuntimeException e) {
            logger.severe("Airport could not be updated due to error: " + e.getMessage());
            throw new AirportUpdateException("Airport could not be updated.");
        }
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        Airport airportToBeDeleted = getAirportById(id);
        airportRepository.delete(airportToBeDeleted);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Airport getAirportById(Integer id) {
        return airportRepository.findById(id).orElseThrow( () -> new AirportNotFoundException("Airport doest not exist."));
    }
}

