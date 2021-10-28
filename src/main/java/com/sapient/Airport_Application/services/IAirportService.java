package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Airport;

import java.util.List;

/**
 * business cases which I really going to expose as the Edge API -->
 */

public interface IAirportService {

    List<Airport> listAllAirports();

    Airport findAirportsByName(String name);

    List<Airport> findAirportsByType(String type);

    Airport findAirportsById(Long id);

    List<Airport> findAirportsByCountry(String country);

    List<Airport> findAirportsByRunways();

    List<Airport> listAllHeliports();

    List<Airport> listAirportsByContinent(String continent);

    Airport getRandomAirport();

    List<Airport> airportsSorted(String key);

}
