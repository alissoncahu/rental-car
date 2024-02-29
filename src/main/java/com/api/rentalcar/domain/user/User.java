package com.api.rentalcar.domain.user;

import com.api.rentalcar.dtos.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@Entity(name="users")
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Primeiro nome é obrigatório")
    private String firstName;

    private String lastName;

    @Column(unique = true)
    @CPF
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Email é obrigatório")
    @Column(unique = true)
    private String email;

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.cpf = data.cpf();
    }

}
