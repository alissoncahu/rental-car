package com.api.rentalcar.dtos;

import java.math.BigDecimal;
import java.util.Date;

public record LocationDTO(BigDecimal dailyRentalPrice, Date locationStart, Date locationEnd) {
}
