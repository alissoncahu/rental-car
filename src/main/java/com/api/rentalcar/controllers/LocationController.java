package com.api.rentalcar.controllers;

import com.api.rentalcar.domain.location.Location;
import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.LocationDTO;
import com.api.rentalcar.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> locations = this.locationService.getAllLocation();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping(path = "/car/{licensePlateCar}")
    public ResponseEntity<List<Location>> getLocationByCar(@PathVariable String licensePlateCar) throws Exception {
        List<Location> location = this.locationService.getLocationByLicensePlateCar(licensePlateCar);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{cpf}")
    public ResponseEntity<List<Location>> getLocationByUser(@PathVariable String cpf) throws Exception {
        List<Location> location = this.locationService.getLocationByCpf(cpf);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
}
