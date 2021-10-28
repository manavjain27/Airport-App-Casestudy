package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAirportsDAO extends JpaRepository<Airport,Long> {

    Optional<Airport> findByName(String name);
    List<Airport> findByType(String type);
    List<Airport> findByCountryName(String country);
}
