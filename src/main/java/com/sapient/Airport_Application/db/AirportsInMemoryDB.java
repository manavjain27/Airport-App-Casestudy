package com.sapient.Airport_Application.db;

import com.sapient.Airport_Application.dao.*;
import com.sapient.Airport_Application.domain.*;
import com.sapient.Airport_Application.functions.TransformerFunctions;
import com.sapient.Airport_Application.helpers.Config;
import com.sapient.Airport_Application.helpers.PropertyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirportsInMemoryDB implements CommandLineRunner {

    @Autowired
    IRunwayDAO runwayDAO;
    @Autowired
    INavAidsDAO navAidsDAO;
    @Autowired
    IRegionDAO regionDAO;
    @Autowired
    ICountriesDAO countriesDAO;
    @Autowired
    IAirportFrequencyDAO airportFrequencyDAO;

    private static final Logger logger = LoggerFactory.getLogger(AirportsInMemoryDB.class);

    private static List<Airport> airportsDB = null;
    private static List<Country> countriesDB = null;
    private static List<Region> regionsDB = null;
    private static List<NavAid> navaidsDB = null;
    private static List<Runway> runwaysDB = null;
    private static List<AirportFrequency> airportFrequenciesDB = null;


    static {
        try {
            airportsDB = Files.readString(Paths.get(PropertyHelper.getProperty(Config.AIRPORTS_CSV.name()))).lines().skip(1).map(TransformerFunctions::stringToAirport).collect(Collectors.toList());
            if (airportsDB != null && logger.isInfoEnabled())
                logger.info(String.format("Airports Database Loaded with %s records", airportsDB.size()));
            regionsDB = Files.readString(Paths.get(PropertyHelper.getProperty(Config.REGIONS_CSV.name()))).lines().skip(1).map(TransformerFunctions::stringToRegion).collect(Collectors.toList());
            if (regionsDB != null && logger.isInfoEnabled())
                logger.info(String.format("Regions Database Loaded with %s records", regionsDB.size()));
            countriesDB = Files.readString(Paths.get(PropertyHelper.getProperty(Config.COUNTRIES_CSV.name()))).lines().skip(1).map(TransformerFunctions::stringToCountry).collect(Collectors.toList());
            if (countriesDB != null && logger.isInfoEnabled())
                logger.info(String.format("Countries Database Loaded with %s records", countriesDB.size()));
            navaidsDB = Files.readString(Paths.get(PropertyHelper.getProperty(Config.NAVAIDS_CSV.name()))).lines().skip(1).map(TransformerFunctions::stringToNavaid).collect(Collectors.toList());
            if (navaidsDB != null && logger.isInfoEnabled())
                logger.info(String.format("NavAids Database Loaded with %s records", navaidsDB.size()));
            runwaysDB = Files.readString(Paths.get(PropertyHelper.getProperty(Config.RUNWAYS_CSV.name()))).lines().skip(1).map(TransformerFunctions::stringToRunway).collect(Collectors.toList());
            if (runwaysDB != null && logger.isInfoEnabled())
                logger.info(String.format("Runways Database Loaded with %s records", runwaysDB.size()));
            airportFrequenciesDB = Files.readString(Paths.get(PropertyHelper.getProperty(Config.AIRPORT_FREQUENCY_CSV.name()))).lines().skip(1).map(TransformerFunctions::stringToAirportFrequency).collect(Collectors.toList());
            if (airportFrequenciesDB != null && logger.isInfoEnabled())
                logger.info(String.format("Airport Frequencies Database Loaded with %s records", airportFrequenciesDB.size()));
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error(e.getMessage());
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


    @Override
    public void run(String... args) throws Exception {
        runwayDAO.saveAll(runwaysDB);
        navAidsDAO.saveAll(navaidsDB);
        regionDAO.saveAll(regionsDB);
        countriesDAO.saveAll(countriesDB);
        airportFrequencyDAO.saveAll(airportFrequenciesDB);

    }
}
