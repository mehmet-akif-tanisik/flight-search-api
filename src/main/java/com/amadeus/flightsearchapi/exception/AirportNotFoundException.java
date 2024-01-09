/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.exception
    FILE            : AirportNotFoundException.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.exception;

public class AirportNotFoundException extends RuntimeException {

    public AirportNotFoundException(String message) {
        super(message);
    }
}
