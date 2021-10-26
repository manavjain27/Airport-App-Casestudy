package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.NavAid;
import com.sapient.Airport_Application.exceptions.ObjectNotFoundException;
import com.sapient.Airport_Application.services.INavService;
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
public class NavaidController {

    private static final Logger LOG = LoggerFactory.getLogger(NavaidController.class);

    @Autowired
    INavService navService;

    @GetMapping("/navaids")
    public ResponseEntity<?> getAllRegions() {
        LOG.info("Navaids are Retrieved");
        return new ResponseEntity<>(navService.listAllNavaids(), HttpStatus.OK);
    }

    @GetMapping("/navaids/{id}")
    public ResponseEntity<NavAid> getNavaidById(@PathVariable(value = "id") Long navId)
            throws ObjectNotFoundException {
        LOG.info("Navaid is retrieved with a particular id : " + navId);
        return navService.findNavaidById(navId).map(navAid -> new ResponseEntity<>(navAid,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/navaidName/{name}")
    public List<NavAid> getNavaidByName(@PathVariable(value = "name") String name)
            throws ObjectNotFoundException {
        LOG.info("Navaid is retrieved with a particular name : " + name);
        return navService.findNavaidByName(name);
    }
}
