package com.rafael.curso.springboot.webapp.springboot_web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.curso.springboot.webapp.springboot_web.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here if needed

}
