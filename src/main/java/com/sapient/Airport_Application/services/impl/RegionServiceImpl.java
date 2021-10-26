package com.sapient.Airport_Application.services.impl;

import com.sapient.Airport_Application.dao.IAirportsDAO;
import com.sapient.Airport_Application.dao.ICountriesDAO;
import com.sapient.Airport_Application.dao.INavAidsDAO;
import com.sapient.Airport_Application.dao.IRegionDAO;
import com.sapient.Airport_Application.domain.Region;
import com.sapient.Airport_Application.services.IRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    IAirportsDAO airportsDAO;
    @Autowired
    IRegionDAO regionDAO;
    @Autowired
    INavAidsDAO navAidsDAO;
    @Autowired
    ICountriesDAO countriesDAO;

    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    public RegionServiceImpl(IAirportsDAO airportsDAO, IRegionDAO regionDAO, INavAidsDAO navAidsDAO, ICountriesDAO countriesDAO) {
        this.airportsDAO = airportsDAO;
        this.regionDAO = regionDAO;
        this.navAidsDAO = navAidsDAO;
        this.countriesDAO = countriesDAO;

    }

    @Override
    public List<Region> listAllRegions() {
        return regionDAO.findAll();
    }

    @Override
    public List<Region> findRegionByName(String name) {
        return regionDAO.findByName(name);
    }

    @Override
    public List<Region> findRegionsByContinent(String continent) {
        return regionDAO.findByContinent(continent);
    }

    @Override
    public Optional<Region> findRegionById(Long id) {
        return regionDAO.findById(id);
    }

    @Override
    public Optional<Region> findRegionByCode(String code) {
        return regionDAO.findByCode(code);
    }

    @Override
    public List<Region> regionsSorted(String key) {
        Comparator<Region> compareByKey = null;
        if (key.equals("name")) {
            compareByKey = Comparator.comparing(Region::getName);
        } else if (key.equals("id")) {
            compareByKey = Comparator.comparing(Region::getId);
        } else {
            compareByKey = Comparator.comparing(Region::getCode);
        }
        return regionDAO.findAll().stream().sorted(compareByKey).collect(Collectors.toList());
    }
}
