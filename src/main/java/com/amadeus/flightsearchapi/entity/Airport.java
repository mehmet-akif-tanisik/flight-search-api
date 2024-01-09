/*-----------------------------------------------------------------------
    PROJECT NAME    : flight-search-api
    PACKAGE NAME    : com.amadeus.flightsearchapi.entity
    FILE            : Airport.java
    AUTHOR          : Mehmet Akif Tanisik
    EMAIL           : mehmetakif.tanisik@solmaz.com
    COMPANY         : SOLMAZ GUMRUK MUSAVIRLIGI A.S.
    
    ABOUT CLASS     : 

-----------------------------------------------------------------------*/

package com.amadeus.flightsearchapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String city;
}
