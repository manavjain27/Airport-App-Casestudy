package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.AirportFrequency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportFrequencyDAO extends JpaRepository<AirportFrequency,Long> {
}
