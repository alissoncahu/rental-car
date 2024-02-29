package com.api.rentalcar.repositories;

import com.api.rentalcar.domain.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findCarByLicensePlateCar(String licensePlateCar);

    Optional<Car> findCarById(Long id);
}
