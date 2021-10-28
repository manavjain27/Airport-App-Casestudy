package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.AirportFrequency;

import java.util.List;

public interface IAirportFrequencyService {

    List<AirportFrequency> listAllAirportFrequencies();

    AirportFrequency findFrequenciesById(Long id);

}
