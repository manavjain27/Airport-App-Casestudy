package com.sapient.Airport_Application.dao.impl;

import com.sapient.Airport_Application.dao.IAirportsDAO;
import com.sapient.Airport_Application.db.AirportsInMemoryDB;
import com.sapient.Airport_Application.domain.Airport;
import com.sapient.Airport_Application.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author AirportDao
 */
@Repository
public class AirportsDAOImpl implements IAirportsDAO {


    /**
     * @param name AirportName
     * @return List<Airport> Airport Lists
     */
    @Override
    public List<Airport> findByAirportName(String name) {
        if(name ==null)
            throw new IllegalArgumentException();
        return AirportsInMemoryDB.airports().stream().filter(r -> r.getName().contains(name)).collect(Collectors.toList());
    }

    /**
     * @param type AirportType
     * @return List<Airport> Airport Lists
     */
    @Override
    public List<Airport> findByAirportType(String type) {
        if (type == null)
            throw new IllegalArgumentException();
        return AirportsInMemoryDB.airports().stream().filter(r -> r.getType().equals(type)).collect(Collectors.toList());
    }


    /**
     * @param country Country
     * @return List<Airport> Airport Lists
     */
    @Override
    public List<Airport> findByAirportCountry(String country) {
        if (country == null)
            throw new IllegalArgumentException();
        return AirportsInMemoryDB.airports().stream().filter(r -> r.getCountryName().equals(country)).collect(Collectors.toList());
    }

    /**
     * @return List<Airport> Airport Lists
     */
    @Override
    public List<Airport> findAll() {
        return AirportsInMemoryDB.airports();
    }

    /**
     * @param id AirportId
     * @return Airport
     */
    public Optional<Airport> findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException();
        return Optional.ofNullable(AirportsInMemoryDB.airports().stream().filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new ObjectNotFoundException("Airport not found for this id :: " + id)));
    }
}
