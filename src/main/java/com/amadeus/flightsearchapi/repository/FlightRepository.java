
package com.amadeus.flightsearchapi.repository;

import com.amadeus.flightsearchapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findFlightsByDepartureAirport_CityAndAndArrivalAirport_CityAndDepartureDateTimeAfter(String departureCity, String arrivalCity, LocalDateTime departureDateTime);
}
