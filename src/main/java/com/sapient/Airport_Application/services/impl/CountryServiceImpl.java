package com.sapient.Airport_Application.services.impl;

import com.sapient.Airport_Application.dao.IAirportsDAO;
import com.sapient.Airport_Application.dao.ICountriesDAO;
import com.sapient.Airport_Application.dao.INavAidsDAO;
import com.sapient.Airport_Application.dao.IRegionDAO;
import com.sapient.Airport_Application.domain.Country;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import com.sapient.Airport_Application.functions.FilterFunctions;
import com.sapient.Airport_Application.services.ICountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    IAirportsDAO airportsDAO;
    @Autowired
    IRegionDAO regionDAO;
    @Autowired
    INavAidsDAO navAidsDAO;
    @Autowired
    ICountriesDAO countriesDAO;

    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    public CountryServiceImpl(IAirportsDAO airportsDAO, IRegionDAO regionDAO, INavAidsDAO navAidsDAO, ICountriesDAO countriesDAO) {
        this.airportsDAO = airportsDAO;
        this.regionDAO = regionDAO;
        this.navAidsDAO = navAidsDAO;
        this.countriesDAO = countriesDAO;

    }

    @Override
    public List<Country> listAllCountries() {
        return countriesDAO.findAll();
    }

    @Override
    public List<Country> findCountryByName(String name) {
        return countriesDAO.findByName(name);
    }

    @Override
    public List<Country> findCountriesByContinent(String continent) {
        return countriesDAO.findByContinent(continent);
    }

    @Override
    public Country findCountryById(Long id) {
        return countriesDAO.findById(id).orElseThrow(() -> new AirportApplicationException("No country found for id "+id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Country findCountryByCode(String code) {
        return countriesDAO.findByCode(code).orElseThrow(() -> new AirportApplicationException("No country found for code "+code, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<String> listAllContinents() {
        List<Country> personListFiltered = countriesDAO.findAll().stream()
                .filter(FilterFunctions.distinctByKey(Country::getContinent))
                .collect(Collectors.toList());
        return personListFiltered.stream().map(Country::getContinent).collect(Collectors.toList());
    }

    @Override
    public List<Country> countriesSorted(String key) {
        Comparator<Country> compareByKey = null;
        if (key.equals("name")) {
            compareByKey = Comparator.comparing(Country::getName);
        } else if (key.equals("id")) {
            compareByKey = Comparator.comparing(Country::getId);
        } else {
            compareByKey = Comparator.comparing(Country::getCode);
        }
        return countriesDAO.findAll().stream().sorted(compareByKey).collect(Collectors.toList());
    }
}
