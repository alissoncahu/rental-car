package com.api.rentalcar.domain.location;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name="location")
@Table(name="location" )
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal dailyRentalPrice;

    private LocalDateTime locationStart;

    private LocalDateTime locationEnd;
}
