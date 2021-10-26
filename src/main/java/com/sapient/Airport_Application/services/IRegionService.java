package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Region;

import java.util.List;
import java.util.Optional;

public interface IRegionService {

    List<Region> listAllRegions();

    List<Region> findRegionByName(String name);

    List<Region> findRegionsByContinent(String continent);

    Optional<Region> findRegionById(Long id);

    Optional<Region> findRegionByCode(String code);

    List<Region> regionsSorted(String key);
}
