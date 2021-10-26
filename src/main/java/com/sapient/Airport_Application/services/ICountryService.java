package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICountryService {

    List<Country> listAllCountries();

    List<Country> findCountryByName(String name);

    List<Country> findCountriesByContinent(String continent);

    Optional<Country> findCountryById(Long id);

    Optional<Country> findCountryByCode(String code);

    List<String> listAllContinents();

    List<Country> countriesSorted(String key);

}
