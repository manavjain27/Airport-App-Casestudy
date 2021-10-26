package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.Runway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRunwayDAO extends JpaRepository<Runway,Long> {
}
