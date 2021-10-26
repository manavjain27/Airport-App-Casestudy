package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.Region;
import com.sapient.Airport_Application.exceptions.ObjectNotFoundException;
import com.sapient.Airport_Application.services.IRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    private static final Logger LOG = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    private IRegionService regionService;

    @GetMapping("/regions")
    public ResponseEntity<?> getAllRegions() {
        LOG.info("Regions are Retrieved");
        return new ResponseEntity<>(regionService.listAllRegions(), HttpStatus.OK);
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable(value = "id") Long regionId)
            throws ObjectNotFoundException {
        LOG.info("Region is retrieved with a particular id : " + regionId);
        return regionService.findRegionById(regionId).map(region -> new ResponseEntity<>(region,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/regionName/{name}")
    public List<Region> getRegionByName(@PathVariable(value = "name") String name)
            throws ObjectNotFoundException {
        LOG.info("Region is retrieved with a particular name : " + name);
        return regionService.findRegionByName(name);
    }

    @GetMapping("/regionContinent/{continent}")
    public List<Region> getRegionByContinent(@PathVariable(value = "continent") String continent)
            throws ObjectNotFoundException {
        LOG.info("Country is retrieved with a particular continent : " + continent);
        return regionService.findRegionsByContinent(continent);
    }

    @GetMapping("/regionCode/{code}")
    public ResponseEntity<Region> getRegionByCode(@PathVariable(value = "code") String code)
            throws ObjectNotFoundException {
        LOG.info("Region is retrieved with a particular code : " + code);
        return regionService.findRegionByCode(code).map(regionCode -> new ResponseEntity<>(regionCode,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/regionsSorted/{name}")
    public ResponseEntity<?> getAllRegionsSorted(@PathVariable(value = "name") String name) {
        LOG.info("Regions are Retrieved in sorted order");
        return new ResponseEntity<>(regionService.regionsSorted(name), HttpStatus.OK);
    }
}
