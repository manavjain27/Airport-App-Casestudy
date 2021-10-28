package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICountriesDAO extends JpaRepository<Country,Long> {

    Optional<Country> findByName(String name);

    List<Country> findByContinent(String name);

    Optional<Country> findByCode(String code);
}
