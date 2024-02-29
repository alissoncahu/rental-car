package com.api.rentalcar.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LocationDTO(BigDecimal dailyRentalPrice, LocalDateTime locationStart, LocalDateTime locationEnd) {
}
