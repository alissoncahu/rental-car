package com.api.rentalcar.dtos;

import jakarta.persistence.Column;

public record CarDTO(String brandCar, String modelCar, String colorCar, String licensePlateCar) {
}
