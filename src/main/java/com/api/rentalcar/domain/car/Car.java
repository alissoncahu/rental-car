package com.api.rentalcar.domain.car;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name="card")
@Table(name="card")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandCar;

    private String modelCar;

    private String colorCar;

    @Column(unique = true)
    private String licensePlateCar;
}
