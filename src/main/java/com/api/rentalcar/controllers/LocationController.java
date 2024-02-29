package com.api.rentalcar.controllers;

import com.api.rentalcar.domain.location.Location;
import com.api.rentalcar.dtos.LocationDTO;
import com.api.rentalcar.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/location")

public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> createTransaction(@Valid @RequestBody LocationDTO transaction) throws Exception {

        Location newLocation = this.locationService.createLocation(transaction);
        return new ResponseEntity<>(newLocation, HttpStatus.OK);

    }
}
