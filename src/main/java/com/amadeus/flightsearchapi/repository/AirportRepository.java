

package com.amadeus.flightsearchapi.repository;

import com.amadeus.flightsearchapi.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
