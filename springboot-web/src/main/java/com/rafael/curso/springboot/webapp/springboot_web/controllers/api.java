package com.rafael.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.curso.springboot.webapp.spring_web.models.AnimalAcuatico;
import com.rafael.curso.springboot.webapp.spring_web.models.AnimalAereo;
import com.rafael.curso.springboot.webapp.spring_web.models.AnimalTerrestre;
import com.rafael.curso.springboot.webapp.spring_web.models.Estudiante;


@RestController
@RequestMapping("/api")
public class api {
    

      @GetMapping("/saludo")
      public  Map<String, Object> saludo() {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Hola, bienvenido");
        return response;
      }

      @GetMapping("/Mostrar_Estudiante")

         public  Map<String, Object> Mostrar_Estudiante() {
            Map<String, Object> response = new HashMap<>();
            Estudiante E01 = 
            new Estudiante( "Rafael", "Pineda", "1230","Fundamentos de Java");
            response.put("mensaje", " Estudiante 01");
            response.put("Estudiante 01", E01);  
            Estudiante E02 = 
            new Estudiante( "Juan", "Jalina", "1240","Fundamentos de Java");
        
        response.put("mensaje", "Estudiante 02");
        response.put("Estudiante 02", E02);
        return response;
      }

      @GetMapping("/Vista")
    public String details(){
      //   model.addAttribute("tittle", "Bienvenido al mundo de Spring Boot");
      //   model.addAttribute("Nombre", "Rafael");
      //   model.addAttribute("Apellido", "Pineda");
      //   model.addAttribute("Profesion", "Desarrollador de Sistemas");
      //   model.addAttribute("Carrera", "Ing. Computacion");
        
        return "Vista";
    }


    @GetMapping("/Portafolio")
    public String Portafolio() {
        return  "Portafolio";
    }


    @GetMapping("/Animales")
    public  Map<String, Object> Animales() {
          Map<String, Object> response_Animal = new HashMap<>();

          AnimalTerrestre Leon = new AnimalTerrestre();
          AnimalAcuatico Tiburon = new AnimalAcuatico();
          Tiburon.setNombre("Tiburon Blanco");

          AnimalAereo Buho = new AnimalAereo();
          Buho.setNombre("Buho");

          response_Animal.put(Tiburon.getNombre(),Tiburon.Avanzar());
          response_Animal.put(Buho.getNombre(),Buho.Avanzar());

          
          return response_Animal;
    }
    
    


}
