package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.Airport;
import com.sapient.Airport_Application.domain.AirportFrequency;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import com.sapient.Airport_Application.services.IAirportFrequencyService;
import com.sapient.Airport_Application.services.IAirportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@Slf4j
@RestController
public class AirportController {

    @Autowired
    private IAirportService airportService;

    @Autowired
    private IAirportFrequencyService airportFrequencyService;

    @GetMapping("/airports")
    public ResponseEntity<?> getAllAirports() {
        log.info("Airports are Retrieved");
        return new ResponseEntity<>(airportService.listAllAirports(), HttpStatus.OK);
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable(value = "id") Long airportId)
            throws AirportApplicationException {
        log.info("Airport is retrieved with a particular id : " + airportId);
        return new ResponseEntity<>(airportService.findAirportsById(airportId),HttpStatus.OK);
    }

    @GetMapping("/airportName/{name}")
    public ResponseEntity<List<Airport>> getAirportByName(@PathVariable(value = "name") String name)
            throws AirportApplicationException {
        log.info("Airport is retrieved with a particular name : " + name);
        return new ResponseEntity<>(airportService.findAirportsByName(name),HttpStatus.OK);
    }

    @GetMapping("/airportType/{type}")
    public ResponseEntity<List<Airport>> getAirportByType(@PathVariable(value = "type") String type)
            throws AirportApplicationException {
        log.info("Airport is retrieved with a particular type : " + type);
       return new ResponseEntity<>(airportService.findAirportsByType(type),HttpStatus.OK);
    }

    @GetMapping("/airportCountry/{countryName}")
    public ResponseEntity<List<Airport>> getAirportByCountry(@PathVariable(value = "countryName") String countryName)
            throws AirportApplicationException {
        log.info("Airport is retrieved with a particular country : " + countryName);
        return new ResponseEntity<>(airportService.findAirportsByCountry(countryName),HttpStatus.OK);
    }

    @GetMapping("/airportsSorted/{sortedKey}")
    public ResponseEntity<?> getAllAirportsSorted(@PathVariable(value = "sortedKey") String sortedKey) {
        log.info("Airports are Retrieved in sorted order");
        return new ResponseEntity<>(airportService.airportsSorted(sortedKey), HttpStatus.OK);
    }

    @GetMapping("/airportsFrequency")
    public ResponseEntity<?> getAllAirportsFrequencies() {
        log.info("Airports Frequencies are Retrieved");
        return new ResponseEntity<>(airportFrequencyService.listAllAirportFrequencies(), HttpStatus.OK);
    }

    @GetMapping("/airportsFrequency/{id}")
    public ResponseEntity<AirportFrequency> getAirportFrequencyById(@PathVariable(value = "id") Long airportId)
            throws AirportApplicationException {
        log.info("Airport Frequency is retrieved with a particular id : " + airportId);
        return new ResponseEntity<>(airportFrequencyService.findFrequenciesById(airportId),HttpStatus.OK);
    }

}
