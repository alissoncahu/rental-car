package com.api.rentalcar.services;

import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.UserDTO;
import com.api.rentalcar.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUserById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }

    public User getUserByCpf(String cpf) throws Exception {
        return this.repository.findUserByCpf(cpf).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }
    @Transactional
    public void saveUser(User user) {
        this.repository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    @Transactional
    public void delete(User user) {
        repository.delete(user);
    }
}
