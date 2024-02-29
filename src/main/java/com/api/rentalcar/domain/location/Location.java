package com.api.rentalcar.domain.location;

import com.api.rentalcar.domain.car.Car;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

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

    private Date locationStart;

    private Date locationEnd;

    @ManyToOne
    private Car licensePlateCar;

}
