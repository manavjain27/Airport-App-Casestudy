package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.Airport;
import com.sapient.Airport_Application.domain.AirportFrequency;
import com.sapient.Airport_Application.exceptions.ObjectNotFoundException;
import com.sapient.Airport_Application.jwt.AuthenticationRequest;
import com.sapient.Airport_Application.jwt.AuthenticationResponse;
import com.sapient.Airport_Application.jwt.JwtUtil;
import com.sapient.Airport_Application.jwt.MyUserDetailsService;
import com.sapient.Airport_Application.services.IAirportFrequencyService;
import com.sapient.Airport_Application.services.IAirportService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Slf4j
@RestController
public class AirportController {

    private static final Logger LOG = LoggerFactory.getLogger(AirportController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtToken;

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
            throws ObjectNotFoundException {
        log.info("Airport is retrieved with a particular id : " + airportId);
        return airportService.findAirportsById(airportId).map(airport -> new ResponseEntity<>(airport,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/airportName/{name}")
    public ResponseEntity<List<Airport>> getAirportByName(@PathVariable(value = "name") String name)
            throws ObjectNotFoundException {
        log.info("Airport is retrieved with a particular name : " + name);
        return new ResponseEntity<>(airportService.findAirportsByCountry(name),HttpStatus.OK);
    }

    @GetMapping("/airportType/{type}")
    public ResponseEntity<List<Airport>> getAirportByType(@PathVariable(value = "type") String type)
            throws ObjectNotFoundException {
        log.info("Airport is retrieved with a particular type : " + type);
       return new ResponseEntity<>(airportService.findAirportsByType(type),HttpStatus.OK);
    }

    @GetMapping("/airportCountry/{countryName}")
    public ResponseEntity<List<Airport>> getAirportByCountry(@PathVariable(value = "countryName") String countryName)
            throws ObjectNotFoundException {
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
            throws ObjectNotFoundException {
        log.info("Airport Frequency is retrieved with a particular id : " + airportId);
        return airportFrequencyService.findFrequenciesById(airportId).map(airport -> new ResponseEntity<>(airport,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api/token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        // authenticating user credentials
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        // if user has been successfully authenticated, generate token.

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtToken.generateToken(userDetails);


        log.info("JWT Generated Successfully: {} ",jwt);
        // send token in response.
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
