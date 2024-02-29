package com.api.rentalcar.services;

import com.api.rentalcar.domain.car.Car;
import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.CarDTO;
import com.api.rentalcar.dtos.UserDTO;
import com.api.rentalcar.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;


    public Car findCarByLicensePlateCar(String licensePlateCar) throws Exception {
        return this.repository.findCarByLicensePlateCar(licensePlateCar).orElseThrow(() -> new Exception("Carro não encontrado!"));
    }

    public Car findCarById(Long id) throws Exception {
        return this.repository.findCarById(id).orElseThrow(() -> new Exception("Carro não encontrado!"));
    }

    public void saveCar(Car car) {
        this.repository.save(car);
    }

    public Car createCar(CarDTO data) {
        Car newCar = new Car(data);
        this.saveCar(newCar);
        return newCar;

    }

    public List<Car> getAllCars() {
        return this.repository.findAll();
    }
}
