package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.Region;

import java.util.List;

public interface IRegionService {

    List<Region> listAllRegions();

    Region findRegionByName(String name);

    List<Region> findRegionsByContinent(String continent);

    Region findRegionById(Long id);

    Region findRegionByCode(String code);

    List<Region> regionsSorted(String key);
}
