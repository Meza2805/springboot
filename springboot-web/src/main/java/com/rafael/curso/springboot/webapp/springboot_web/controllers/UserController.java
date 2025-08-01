package com.rafael.curso.springboot.webapp.springboot_web.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.curso.springboot.webapp.springboot_web.entities.User;
import com.rafael.curso.springboot.webapp.springboot_web.repositories.UserRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
   private  UserRepository userRepository; 

    // Constructor para inyección de dependencias
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

@PostMapping("/create")
public ResponseEntity<String> createUser(@RequestBody User user) ///Sirve para hacer una insercion de usuario uno a uno
{
    ///validar que el correo tenga un formato correcto 
    if (user.getEmail() != null && !user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("❌ Error: El formato del correo electrónico es incorrecto.");
    }       

    if (user.getName() == null || user.getEmail() == null) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("❌ Error: El nombre y el correo electrónico son obligatorios.");
    }
    userRepository.save(user);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("✅ Usuario insertado correctamente en la base de datos.");
    }



  @GetMapping("/list_users")
public ResponseEntity<List<User>> getAllUsers() 
{
    List<User> users = userRepository.findAll();
    if (users.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.ok(users);
}
  
}
