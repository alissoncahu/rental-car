package com.api.rentalcar.dtos;

import com.api.rentalcar.domain.car.Car;
import com.api.rentalcar.domain.user.User;

import java.math.BigDecimal;
import java.util.Date;

public record LocationDTO(Date locationStart, Date locationEnd, Long leaserId, Long locatorId) {
}
