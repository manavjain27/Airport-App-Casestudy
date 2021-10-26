package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Airport;
import com.sapient.Airport_Application.domain.NavAid;
import com.sapient.Airport_Application.domain.Region;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * business cases which I really going to expose as the Edge API -->
 */

public interface IAirportService {

    List<Airport> listAllAirports();

    List<Airport> findAirportsByName(String name);

    List<Airport> findAirportsByType(String type);

    Optional<Airport> findAirportsById(Long id);

    List<Airport> findAirportsByCountry(String country);

    List<Airport> findAirportsByRunways();

    List<Airport> listAllHeliports();

    List<Airport> listAirportsByContinent(String continent);

    Airport getRandomAirport();

    List<Airport> airportsSorted(String key);

}
