package com.api.rentalcar.domain.car;

import com.api.rentalcar.dtos.CarDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity(name="cars")
@Table(name="cars")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Fabricante do carro é obrigatório")
    private String brandCar;

    @NotBlank (message = "Modelo do carro é obrigatório")
    private String modelCar;

    @NotBlank (message = "Cor do carro é obrigatória")
    private String colorCar;

    @NotBlank (message = "Placa do carro é obrigatório")
    @Column(unique = true)
    private String licensePlateCar;

    public Car(CarDTO data){
        this.brandCar = data.brandCar();
        this.modelCar = data.modelCar();
        this.colorCar = data.colorCar();
        this.licensePlateCar = data.licensePlateCar();
    }
}
