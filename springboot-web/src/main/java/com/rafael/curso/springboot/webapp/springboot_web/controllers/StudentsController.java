package com.rafael.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.curso.springboot.webapp.springboot_web.entities.Students;
import com.rafael.curso.springboot.webapp.springboot_web.repositories.StudentsRepository;


@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsRepository studentsRepository;
   

    // Endpoint para registrar un estudiante
    @PostMapping("/insert")
    public ResponseEntity<Map<String, Object>> insertarEstudiante(@RequestBody Students student) {
        Map<String, Object> response = new HashMap<>();

        // Validación de campos obligatorios
        if (student.getName() == null || student.getEmail() == null ||
            student.getName().isEmpty() || student.getEmail().isEmpty()) {
            response.put("mensaje", "El nombre y el correo no pueden estar vacíos");
            return ResponseEntity.badRequest().body(response);
        }

        // Validación de formato de correo electrónico
        if (!student.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            response.put("mensaje", "El correo electrónico no tiene un formato válido");
            return ResponseEntity.badRequest().body(response);
        }

        // Guardar el estudiante en la base de datos
        Students guardado = studentsRepository.save(student);
        response.put("mensaje", "Estudiante registrado correctamente");
        response.put("datos", guardado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
}

    // Endpoint para obtener todos los estudiantes      
    @PostMapping("/getAll")
    public ResponseEntity<Map<String, Object>> obtenerEstudiantes() {
        Map<String, Object> response = new HashMap<>();
        response.put("datos", studentsRepository.findAll());
        return ResponseEntity.ok(response);
    }

    // Endpoint para eliminar un estudiante por ID
    @PostMapping("/delete")
    public ResponseEntity<Map<String, Object>> eliminarEstudiante(@RequestBody Map<String, Long> request) {

        Map<String, Object> response = new HashMap<>();
        Long id = request.get("id");

        if (id == null) {
            response.put("mensaje", "El ID del estudiante es requerido");
            return ResponseEntity.badRequest().body(response);
        }

        studentsRepository.deleteById(id);
        response.put("mensaje", "Estudiante eliminado correctamente");
        return ResponseEntity.ok(response);
    }


    // Endpoint para actualizar un estudiante
    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> actualizarEstudiante(@RequestBody Students student) {
        Map<String, Object> response = new HashMap<>();

        // Validación de campos obligatorios
        if (student.getId() == null) {
            response.put("mensaje", "El ID del estudiante es requerido");
            return ResponseEntity.badRequest().body(response);
        }

        if (student.getName() == null || student.getEmail() == null ||
            student.getName().isEmpty() || student.getEmail().isEmpty()) {
            response.put("mensaje", "El nombre y el correo no pueden estar vacíos");
            return ResponseEntity.badRequest().body(response);
        }

        // Validación de formato de correo electrónico
        if (!student.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            response.put("mensaje", "El correo electrónico no tiene un formato válido");
            return ResponseEntity.badRequest().body(response);
        }

        // Actualizar el estudiante en la base de datos
        Students actualizado = studentsRepository.save(student);
        response.put("mensaje", "Estudiante actualizado correctamente");
        response.put("datos", actualizado);
        return ResponseEntity.ok(response);
    }

    // Endpoint para eliminar un estudiante por ID usando @DeleteMapping
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> eliminarEstudiante(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        if (!studentsRepository.existsById(id)) {
            response.put("mensaje", "El estudiante con ID " + id + " no existe");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        studentsRepository.deleteById(id);
        response.put("mensaje", "Estudiante eliminado correctamente");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}")
public ResponseEntity<Map<String, Object>> actualizarEstudiante(
        @PathVariable Long id,
        @RequestBody Students nuevosDatos) {
    
    Map<String, Object> response = new HashMap<>();

    Optional<Students> estudianteOptional = studentsRepository.findById(id);
    if (!estudianteOptional.isPresent()) {
        response.put("mensaje", "El estudiante con ID " + id + " no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    Students estudianteExistente = estudianteOptional.get();

    // Solo actualiza los campos que no son nulos
    if (nuevosDatos.getName() != null && !nuevosDatos.getName().isEmpty()) {
        estudianteExistente.setName(nuevosDatos.getName());
    }

    if (nuevosDatos.getEmail() != null && !nuevosDatos.getEmail().isEmpty()) {
        // Validación de formato de correo
        if (!nuevosDatos.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            response.put("mensaje", "El correo electrónico no tiene un formato válido");
            return ResponseEntity.badRequest().body(response);
        }
        estudianteExistente.setEmail(nuevosDatos.getEmail());
    }

    // Puedes agregar más validaciones y campos aquí

    Students actualizado = studentsRepository.save(estudianteExistente);
    response.put("mensaje", "Estudiante actualizado correctamente");
    response.put("datos", actualizado);
    return ResponseEntity.ok(response);
}


      }
