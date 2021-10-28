package com.sapient.Airport_Application.services.impl;

import com.sapient.Airport_Application.dao.IAirportsDAO;
import com.sapient.Airport_Application.dao.ICountriesDAO;
import com.sapient.Airport_Application.dao.INavAidsDAO;
import com.sapient.Airport_Application.dao.IRegionDAO;
import com.sapient.Airport_Application.domain.NavAid;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import com.sapient.Airport_Application.services.INavService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavaidServiceImpl implements INavService {

    @Autowired
    IAirportsDAO airportsDAO;
    @Autowired
    IRegionDAO regionDAO;
    @Autowired
    INavAidsDAO navAidsDAO;
    @Autowired
    ICountriesDAO countriesDAO;

    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    public NavaidServiceImpl(IAirportsDAO airportsDAO, IRegionDAO regionDAO, INavAidsDAO navAidsDAO, ICountriesDAO countriesDAO) {
        this.airportsDAO = airportsDAO;
        this.regionDAO = regionDAO;
        this.navAidsDAO = navAidsDAO;
        this.countriesDAO = countriesDAO;

    }

    @Override
    public List<NavAid> listAllNavaids() {
        return navAidsDAO.findAll();
    }

    @Override
    public List<NavAid> findNavaidByName(String name) {
        return navAidsDAO.findByName(name);
    }

    @Override
    public NavAid findNavaidById(Long id) {
        return navAidsDAO.findById(id).orElseThrow(() -> new AirportApplicationException("No navaid found for id "+id, HttpStatus.NOT_FOUND));
    }
}
