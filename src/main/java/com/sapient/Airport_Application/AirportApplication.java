package com.sapient.Airport_Application;

import com.sapient.Airport_Application.dao.*;
import com.sapient.Airport_Application.db.AirportsInMemoryDB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@SpringBootApplication
public class AirportApplication implements CommandLineRunner {

	@Autowired
	IAirportsDAO airportsDAO;
	@Autowired
	IRunwayDAO runwayDAO;
	@Autowired
	INavAidsDAO navAidsDAO;
	@Autowired
	IRegionDAO regionDAO;
	@Autowired
	ICountriesDAO countriesDAO;
	@Autowired
	AirportsInMemoryDB airportsDB;

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("CSV Data into H2 Database");
		airportsDAO.saveAll(AirportsInMemoryDB.airports());
		runwayDAO.saveAll(AirportsInMemoryDB.runways());
		navAidsDAO.saveAll(AirportsInMemoryDB.navaids());
		regionDAO.saveAll(AirportsInMemoryDB.regions());
		countriesDAO.saveAll(AirportsInMemoryDB.countries());
	}

}
