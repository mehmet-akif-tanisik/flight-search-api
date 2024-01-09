/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.exception
    FILE            : FlightUpdateException.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.exception;

public class FlightUpdateException extends RuntimeException {
    public FlightUpdateException(String message) {
        super(message);
    }
}
