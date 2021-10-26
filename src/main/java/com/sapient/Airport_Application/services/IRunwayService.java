package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Runway;

import java.util.List;
import java.util.Optional;

public interface IRunwayService {

    List<Runway> listAllRunways();

    Optional<Runway> findRunwaysById(Long id);

    List<Runway> runwaysSorted(String key);
}
