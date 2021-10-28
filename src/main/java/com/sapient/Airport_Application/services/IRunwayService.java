package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Runway;

import java.util.List;

public interface IRunwayService {

    List<Runway> listAllRunways();

    Runway findRunwaysById(Long id);

    List<Runway> runwaysSorted(String key);
}
