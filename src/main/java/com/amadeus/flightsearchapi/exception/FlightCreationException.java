/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.exception
    FILE            : FlightCreationException.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.exception;

public class FlightCreationException extends RuntimeException {
    public FlightCreationException(String message) {
        super(message);
    }
}
