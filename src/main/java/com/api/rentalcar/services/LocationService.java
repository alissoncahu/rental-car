package com.api.rentalcar.services;

import com.api.rentalcar.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LocationService {
    @Autowired
    private CarRepository repository;
}
