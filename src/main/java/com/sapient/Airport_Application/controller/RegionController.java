package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.Region;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import com.sapient.Airport_Application.services.IRegionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@Slf4j
@RestController
public class RegionController {

    @Autowired
    private IRegionService regionService;

    @GetMapping("/regions")
    public ResponseEntity<?> getAllRegions() {
        log.info("Regions are Retrieved");
        return new ResponseEntity<>(regionService.listAllRegions(), HttpStatus.OK);
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable(value = "id") Long regionId)
            throws AirportApplicationException {
        log.info("Region is retrieved with a particular id : " + regionId);
        return new ResponseEntity<>(regionService.findRegionById(regionId),HttpStatus.OK);
    }

    @GetMapping("/regionName/{name}")
    public ResponseEntity<Region> getRegionByName(@PathVariable(value = "name") String name)
            throws AirportApplicationException {
        log.info("Region is retrieved with a particular name : " + name);
        return new ResponseEntity<>(regionService.findRegionByName(name),HttpStatus.OK);
    }

    @GetMapping("/regionContinent/{continent}")
    public ResponseEntity<List<Region>> getRegionByContinent(@PathVariable(value = "continent") String continent)
            throws AirportApplicationException {
        log.info("Country is retrieved with a particular continent : " + continent);
        return new ResponseEntity<>(regionService.findRegionsByContinent(continent),HttpStatus.OK);
    }

    @GetMapping("/regionCode/{code}")
    public ResponseEntity<Region> getRegionByCode(@PathVariable(value = "code") String code)
            throws AirportApplicationException {
        log.info("Region is retrieved with a particular code : " + code);
        return new ResponseEntity<>(regionService.findRegionByCode(code),HttpStatus.OK);
    }

    @GetMapping("/regionsSorted/{name}")
    public ResponseEntity<?> getAllRegionsSorted(@PathVariable(value = "name") String name) {
        log.info("Regions are Retrieved in sorted order");
        return new ResponseEntity<>(regionService.regionsSorted(name), HttpStatus.OK);
    }
}
