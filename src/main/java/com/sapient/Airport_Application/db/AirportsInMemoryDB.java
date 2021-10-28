package com.sapient.Airport_Application.db;

import com.sapient.Airport_Application.dao.*;
import com.sapient.Airport_Application.domain.*;
import com.sapient.Airport_Application.functions.TransformerFunctions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AirportsInMemoryDB {

    private static List<Airport> airportsDB = null;
    private static List<Country> countriesDB = null;
    private static List<Region> regionsDB = null;
    private static List<NavAid> navaidsDB = null;
    private static List<Runway> runwaysDB = null;
    private static List<AirportFrequency> airportFrequenciesDB = null;

    static {
        try {
            airportsDB = Files.readString(Paths.get(AirportsInMemoryDB.class.getClassLoader().getResource("airports.csv").toURI())).lines().skip(1).map(TransformerFunctions::stringToAirport).collect(Collectors.toList());
            if (airportsDB != null && log.isInfoEnabled())
                log.info(String.format("Airports Database Loaded with %s records", airportsDB.size()));
            regionsDB = Files.readString(Paths.get(AirportsInMemoryDB.class.getClassLoader().getResource("regions.csv").toURI())).lines().skip(1).map(TransformerFunctions::stringToRegion).collect(Collectors.toList());
            if (regionsDB != null && log.isInfoEnabled())
                log.info(String.format("Regions Database Loaded with %s records", regionsDB.size()));
            countriesDB = Files.readString(Paths.get(AirportsInMemoryDB.class.getClassLoader().getResource("countries.csv").toURI())).lines().skip(1).map(TransformerFunctions::stringToCountry).collect(Collectors.toList());
            if (countriesDB != null && log.isInfoEnabled())
                log.info(String.format("Countries Database Loaded with %s records", countriesDB.size()));
            navaidsDB = Files.readString(Paths.get(AirportsInMemoryDB.class.getClassLoader().getResource("navaids.csv").toURI())).lines().skip(1).map(TransformerFunctions::stringToNavaid).collect(Collectors.toList());
            if (navaidsDB != null && log.isInfoEnabled())
                log.info(String.format("NavAids Database Loaded with %s records", navaidsDB.size()));
            runwaysDB = Files.readString(Paths.get(AirportsInMemoryDB.class.getClassLoader().getResource("runways.csv").toURI())).lines().skip(1).map(TransformerFunctions::stringToRunway).collect(Collectors.toList());
            if (runwaysDB != null && log.isInfoEnabled())
                log.info(String.format("Runways Database Loaded with %s records", runwaysDB.size()));
            airportFrequenciesDB = Files.readString(Paths.get(AirportsInMemoryDB.class.getClassLoader().getResource("airport-frequencies.csv").toURI())).lines().skip(1).map(TransformerFunctions::stringToAirportFrequency).collect(Collectors.toList());
            if (airportFrequenciesDB != null && log.isInfoEnabled())
                log.info(String.format("Airport Frequencies Database Loaded with %s records", airportFrequenciesDB.size()));
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * @return List<Airport>
     */

    public static synchronized List<Airport> airports() {
        return airportsDB;
    }


    /**
     * @return List<NavAid>
     */
    public static List<NavAid> navaids() {
        return navaidsDB;
    }


    /**
     * @return List<Country>
     */
    public static List<Country> countries() {
        return countriesDB;
    }


    /**
     * @return List<Region>
     */
    public static List<Region> regions() {
        return regionsDB;
    }

    /**
     * @return List<Runway>
     */
    public static List<Runway> runways() {
        return runwaysDB;
    }

}
