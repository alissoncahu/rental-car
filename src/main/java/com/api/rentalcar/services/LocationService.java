package com.api.rentalcar.services;

import com.api.rentalcar.domain.car.Car;
import com.api.rentalcar.domain.location.Location;
import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.LocationDTO;
import com.api.rentalcar.repositories.CarRepository;
import com.api.rentalcar.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private LocationService locationService;

    public Location createLocation(LocationDTO location) throws Exception{
        Car leaser = this.carService.findCarByLicensePlateCar(location.licensePlateCar());
        User locator = this.userService.findUserByCpf(location.cpfLocator());

        Location newLocation = new Location();
        newLocation.setLocationStart(location.locationStart());
        newLocation.setLocationEnd(location.locationEnd());
        newLocation.setLeased(leaser);
        newLocation.setLocator(locator);

        this.repository.save(newLocation);

        return newLocation;
    }
}
