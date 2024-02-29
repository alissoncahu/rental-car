package com.api.rentalcar.domain.user;

import com.api.rentalcar.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

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

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.cpf = data.cpf();
    }

}
