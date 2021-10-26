package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.AirportFrequency;

import java.util.List;
import java.util.Optional;

public interface IAirportFrequencyService {

    List<AirportFrequency> listAllAirportFrequencies();

    Optional<AirportFrequency> findFrequenciesById(Long id);

}
