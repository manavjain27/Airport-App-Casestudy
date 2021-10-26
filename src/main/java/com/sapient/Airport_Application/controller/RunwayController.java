package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.Runway;
import com.sapient.Airport_Application.exceptions.ObjectNotFoundException;
import com.sapient.Airport_Application.services.IRunwayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
public class RunwayController {

    @Autowired
    private IRunwayService runwayService;

    @GetMapping("/runways")
    public ResponseEntity<?> getAllRunways() {
        log.info("Runways are Retrieved");
        return new ResponseEntity<>(runwayService.listAllRunways(), HttpStatus.OK);
    }

    @GetMapping("/runways/{id}")
    public ResponseEntity<Runway> getRunwayById(@PathVariable(value = "id") Long runwayId)
            throws ObjectNotFoundException {
        log.info("Runway is retrieved with a particular id : " + runwayId);
        return runwayService.findRunwaysById(runwayId).map(runway -> new ResponseEntity<>(runway,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/runwaysSorted/{sortedKey}")
    public ResponseEntity<?> getAllRunwaysSorted(@PathVariable(value = "sortedKey") String sortedKey) {
        log.info("Runways are Retrieved in sorted order");
        return new ResponseEntity<>(runwayService.runwaysSorted(sortedKey), HttpStatus.OK);
    }
}
