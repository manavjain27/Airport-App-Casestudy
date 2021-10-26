package com.sapient.Airport_Application.services.impl;

import com.sapient.Airport_Application.dao.IAirportFrequencyDAO;
import com.sapient.Airport_Application.domain.AirportFrequency;
import com.sapient.Airport_Application.services.IAirportFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportFrequencyServiceImpl implements IAirportFrequencyService {

    @Autowired
    IAirportFrequencyDAO airportFrequencyDAO;

    @Override
    public List<AirportFrequency> listAllAirportFrequencies() {
        return airportFrequencyDAO.findAll();
    }

    @Override
    public Optional<AirportFrequency> findFrequenciesById(Long id) {
        return airportFrequencyDAO.findById(id);
    }
}
