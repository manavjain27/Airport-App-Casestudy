package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.Country;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import com.sapient.Airport_Application.services.ICountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountries() {
        log.info("Countries are Retrieved");
        return new ResponseEntity<>(countryService.listAllCountries(), HttpStatus.OK);
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Long countryId)
            throws AirportApplicationException {
        log.info("Country is retrieved with a particular id : " + countryId);
        return new ResponseEntity<>(countryService.findCountryById(countryId),HttpStatus.OK);
    }

    @GetMapping("/countryName/{name}")
    public ResponseEntity<List<Country>> getCountryByName(@PathVariable(value = "name") String name)
            throws AirportApplicationException {
        log.info("Country is retrieved with a particular name : " + name);
        return new ResponseEntity<>(countryService.findCountryByName(name),HttpStatus.OK);
    }

    @GetMapping("/countryContinent/{continent}")
    public ResponseEntity<List<Country>> getCountryByContinent(@PathVariable(value = "continent") String continent)
            throws AirportApplicationException {
        log.info("Country is retrieved with a particular continent : " + continent);
        return new ResponseEntity<>(countryService.findCountriesByContinent(continent), HttpStatus.OK);
    }

    @GetMapping("/countryCode/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable(value = "code") String code)
            throws AirportApplicationException {
        log.info("Country is retrieved with a particular code : " + code);
        return new ResponseEntity<>(countryService.findCountryByCode(code),HttpStatus.OK);
    }

    @GetMapping("/countriesSorted/{sortedKey}")
    public ResponseEntity<?> getAllCountriesSorted(@PathVariable(value = "sortedKey") String sortedKey) {
        log.info("Countries are Retrieved in sorted order");
        return new ResponseEntity<>(countryService.countriesSorted(sortedKey), HttpStatus.OK);
    }

    @GetMapping("/continents")
    public ResponseEntity<?> getAllContinents() {
        log.info("Continents are Retrieved");
        return new ResponseEntity<>(countryService.listAllContinents(), HttpStatus.OK);
    }

}
