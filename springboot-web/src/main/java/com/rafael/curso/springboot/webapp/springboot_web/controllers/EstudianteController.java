package com.rafael.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.curso.springboot.webapp.spring_web.models.Estudiante;

@RestController
@RequestMapping("/estudiantes")

public class EstudianteController {

    @PostMapping("/Registrar_Estudiante")
    
    public Map<String, Object> registrarEstudiante(@RequestBody Estudiante estudiante) {
        Map<String, Object> response = new HashMap<>();

        response.put("mensaje", "Estudiante registrado correctamente");
        response.put("datos", estudiante);

        return response;
    }
}

