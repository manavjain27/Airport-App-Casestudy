package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Country;

import java.util.List;

public interface ICountryService {

    List<Country> listAllCountries();

    List<Country> findCountryByName(String name);

    List<Country> findCountriesByContinent(String continent);

    Country findCountryById(Long id);

    Country findCountryByCode(String code);

    List<String> listAllContinents();

    List<Country> countriesSorted(String key);

}
