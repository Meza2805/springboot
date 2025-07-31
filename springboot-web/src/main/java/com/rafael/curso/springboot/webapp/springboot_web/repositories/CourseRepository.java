package com.rafael.curso.springboot.webapp.springboot_web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.curso.springboot.webapp.springboot_web.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Additional query methods can be defined here if needed

}
