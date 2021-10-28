package com.sapient.Airport_Application.services.impl;

import com.sapient.Airport_Application.dao.*;
import com.sapient.Airport_Application.domain.Runway;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import com.sapient.Airport_Application.services.IRunwayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RunwayServiceImpl implements IRunwayService {

    @Autowired
    IAirportsDAO airportsDAO;
    @Autowired
    IRegionDAO regionDAO;
    @Autowired
    INavAidsDAO navAidsDAO;
    @Autowired
    ICountriesDAO countriesDAO;
    @Autowired
    IRunwayDAO runwayDAO;

    private static final Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);

    public RunwayServiceImpl(IAirportsDAO airportsDAO, IRegionDAO regionDAO, INavAidsDAO navAidsDAO, ICountriesDAO countriesDAO,IRunwayDAO runwayDAO) {
        this.airportsDAO = airportsDAO;
        this.regionDAO = regionDAO;
        this.navAidsDAO = navAidsDAO;
        this.countriesDAO = countriesDAO;
        this.runwayDAO = runwayDAO;

    }

    @Override
    public List<Runway> listAllRunways() {
        return runwayDAO.findAll();
    }

    @Override
    public Runway findRunwaysById(Long id) {
        return runwayDAO.findById(id).orElseThrow(() -> new AirportApplicationException("No runway found for id "+id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Runway> runwaysSorted(String key) {
        Comparator<Runway> compareByKey = Comparator.comparing(Runway::getId);

        return runwayDAO.findAll().stream().sorted(compareByKey).collect(Collectors.toList());
    }
}
