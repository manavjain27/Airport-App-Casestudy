package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRegionDAO extends JpaRepository<Region,Long> {
    Optional<Region> findByCode(String code);
    List<Region> findByContinent(String continent);
    List<Region> findByName(String name);
}
