package com.api.rentalcar.repositories;

import com.api.rentalcar.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

//    Optional<Location> findLocationByLicencePlateCar(String licensePlateCar);
}
