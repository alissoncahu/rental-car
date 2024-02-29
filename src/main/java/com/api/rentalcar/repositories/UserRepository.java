package com.api.rentalcar.repositories;

import com.api.rentalcar.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByCpf(String cpf);

    Optional<User> findUserById(Long id);
}
