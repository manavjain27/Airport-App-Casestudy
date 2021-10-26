package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.Airport;

import java.util.List;

public interface IAirportsDAO extends IDAO<Airport> {

    List<Airport> findByAirportName(String name);
    List<Airport> findByAirportType(String type);
    List<Airport> findByAirportCountry(String country);
}
