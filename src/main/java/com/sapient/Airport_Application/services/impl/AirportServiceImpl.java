package com.sapient.Airport_Application.services.impl;

import com.sapient.Airport_Application.dao.IAirportsDAO;
import com.sapient.Airport_Application.dao.ICountriesDAO;
import com.sapient.Airport_Application.dao.INavAidsDAO;
import com.sapient.Airport_Application.dao.IRegionDAO;
import com.sapient.Airport_Application.domain.Airport;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import com.sapient.Airport_Application.helpers.AirportType;
import com.sapient.Airport_Application.services.IAirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements IAirportService {

    @Autowired
    IAirportsDAO airportsDAO;
    @Autowired
    IRegionDAO regionDAO;
    @Autowired
    INavAidsDAO navAidsDAO;
    @Autowired
    ICountriesDAO countriesDAO;

    private static final Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);

    public AirportServiceImpl(IAirportsDAO airportsDAO, IRegionDAO regionDAO, INavAidsDAO navAidsDAO, ICountriesDAO countriesDAO) {
        this.airportsDAO = airportsDAO;
        this.regionDAO = regionDAO;
        this.navAidsDAO = navAidsDAO;
        this.countriesDAO = countriesDAO;

    }

    @Override
    public List<Airport> listAllAirports() {
        return airportsDAO.findAll();
    }

    @Override
    public List<Airport> findAirportsByName(String name) {
        return airportsDAO.findByName(name);
    }

    @Override
    public List<Airport> findAirportsByType(String type) {
        return airportsDAO.findByType(type);
    }

    @Override
    public Airport findAirportsById(Long id) {
        return airportsDAO.findById(id).orElseThrow(() -> new AirportApplicationException("No airport found for id "+id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Airport> findAirportsByCountry(String country) {
        return airportsDAO.findByCountryName(country);
    }

    @Override
    public List<Airport> findAirportsByRunways() {
        throw new RuntimeException("No Implementation ");
    }

    @Override
    public List<Airport> listAllHeliports() {
        return airportsDAO.findByType(AirportType.HELIPORT.heliport());
    }

    @Override
    public List<Airport> listAirportsByContinent(String continent) {
        return Collections.emptyList();
    }

    @Override
    public Airport getRandomAirport() {
        Random r = new Random();
        int low = 1;
        int high = airportsDAO.findAll().size();
        int result = r.nextInt(high - low) + low;
        return airportsDAO.findAll().get(result);
    }

    @Override
    public List<Airport> airportsSorted(String key) {
        Comparator<Airport> compareByKey = null;
        if (key.equals("name")) {
            compareByKey = Comparator.comparing(Airport::getName);
        } else if (key.equals("id")) {
            compareByKey = Comparator.comparing(Airport::getId);
        }
        return airportsDAO.findAll().stream().sorted(compareByKey).collect(Collectors.toList());
    }

}
