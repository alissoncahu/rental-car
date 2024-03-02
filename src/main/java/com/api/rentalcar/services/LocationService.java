package com.api.rentalcar.services;

import com.api.rentalcar.domain.car.Car;
import com.api.rentalcar.domain.location.Location;
import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.LocationDTO;
import com.api.rentalcar.repositories.CarRepository;
import com.api.rentalcar.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Location> getAllLocation(){
        return this.repository.findAll();
    }

    public List<Location> getLocationByLicensePlateCar(String licensePlateCar) throws Exception {
        Car leaser = this.carService.getCarByLicensePlateCar(licensePlateCar);
        return this.repository.findLocationByLeased(leaser);
    }

    public List<Location> getLocationByCpf(String cpf) throws Exception {
        User locator = this.userService.getUserByCpf(cpf);
        return this.repository.findLocationByLocator(locator);
    }

    public Location createLocation(LocationDTO location) throws Exception{
        Car leaser = this.carService.getCarByLicensePlateCar(location.licensePlateCar());
        User locator = this.userService.getUserByCpf(location.cpfLocator());

        for(Location l : getLocationByLicensePlateCar(location.licensePlateCar())){
            if(location.locationStart().compareTo(l.getLocationStart()) >= 0
                    && location.locationStart().compareTo(l.getLocationEnd()) <= 0){
                throw new Exception("Carro "+leaser.getBrandCar()+" "+leaser.getModelCar()+" de placa "+leaser.getLicensePlateCar()+" estará locado pelo usuário "+l.getLocator().getFirstName()+" "+l.getLocator().getLastName()+" neste período");
            }
        }

        Location newLocation = new Location();
        newLocation.setLocationStart(location.locationStart());
        newLocation.setLocationEnd(location.locationEnd());
        newLocation.setLeased(leaser);
        newLocation.setLocator(locator);

        this.repository.save(newLocation);

        return newLocation;
    }
}
