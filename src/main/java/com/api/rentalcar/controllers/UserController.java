package com.api.rentalcar.controllers;

import com.api.rentalcar.domain.user.User;
import com.api.rentalcar.dtos.UserDTO;
import com.api.rentalcar.repositories.UserRepository;
import com.api.rentalcar.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<User> getUserByCpf(@PathVariable String cpf) throws Exception {
        User user = this.userService.getUserByCpf(cpf);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception {
        User user = this.userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{cpf}")
    public ResponseEntity<Object> deleteUserByCpf(@PathVariable String cpf) throws Exception {
        User user = this.userService.getUserByCpf(cpf);
        this.userService.delete(user);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) throws Exception {
        User user = this.userService.getUserById(id);
        this.userService.delete(user);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDto) throws Exception {
        User user = this.userService.getUserById(id);

        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setCpf(userDto.cpf());
        user.setEmail(userDto.email());

        this.repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
