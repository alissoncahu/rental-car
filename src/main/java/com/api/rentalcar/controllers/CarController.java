package com.api.rentalcar.controllers;

import com.api.rentalcar.domain.car.Car;
import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.CarDTO;
import com.api.rentalcar.repositories.CarRepository;
import com.api.rentalcar.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping("/cars")

public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository repository;

    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarDTO car){
        Car newCar = carService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = this.carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping(path = "/{licensePlateCar}")
    public ResponseEntity<Car> getCarByLicensePlateCar(@PathVariable String licensePlateCar) throws Exception {
        Car car = this.carService.findCarByLicensePlateCar(licensePlateCar);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getCarByLicensePlateCar(@PathVariable Long id) throws Exception {
        Car car = this.carService.findCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{licensePlateCar}")
    public ResponseEntity<Object> deleteCarByLicensePlateCar(@PathVariable String licensePlateCar) throws Exception {
        Car car = this.carService.findCarByLicensePlateCar(licensePlateCar);
        this.carService.delete(car);
        return ResponseEntity.status(HttpStatus.OK).body("Carro excluído com sucesso");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteCarById(@PathVariable Long id) throws Exception {
        Car car = this.carService.findCarById(id);
        this.carService.delete(car);
        return ResponseEntity.status(HttpStatus.OK).body("Carro excluído com sucesso");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO carDto) throws Exception {
        Car car = this.carService.findCarById(id);

        car.setBrandCar(carDto.brandCar());
        car.setColorCar(carDto.colorCar());
        car.setModelCar(carDto.modelCar());
        car.setLicensePlateCar(carDto.licensePlateCar());

        this.repository.save(car);
        return new ResponseEntity<>(car, HttpStatus.ACCEPTED);
    }
}
