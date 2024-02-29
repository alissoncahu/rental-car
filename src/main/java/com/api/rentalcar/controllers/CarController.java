package com.api.rentalcar.controllers;

import com.api.rentalcar.domain.car.Car;
import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.CarDTO;
import com.api.rentalcar.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/cars")

public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> createUser(@Valid @RequestBody CarDTO car){

        Car newCar = carService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = this.carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);

    }
}
