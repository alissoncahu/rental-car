package com.api.rentalcar.repositories;

import com.api.rentalcar.domain.car.Car;
import com.api.rentalcar.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findLocationByLeased(Car leased);
}
