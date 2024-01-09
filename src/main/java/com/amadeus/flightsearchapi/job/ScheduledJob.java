

package com.amadeus.flightsearchapi.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJob {
    private final FlightDataLoader flightDataLoader;
    @Autowired
    public ScheduledJob(FlightDataLoader flightDataLoader) {
        this.flightDataLoader = flightDataLoader;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void loadMockFlightsToDatabase() {
        // Mocking api get request here to load the data from json files using flightDataLoader every midnight
        flightDataLoader.sendApiRequestToGetFlightData();
    }
}
