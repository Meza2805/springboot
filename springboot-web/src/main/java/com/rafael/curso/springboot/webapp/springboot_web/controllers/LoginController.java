package com.rafael.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.curso.springboot.webapp.spring_web.models.Login;


@RestController
@RequestMapping("/login")
public class LoginController {

     @PostMapping("/Acceso")

    public Map<String, Object> AccesoApp(@RequestBody Login acceso) {
        Map<String, Object> response = new HashMap<>();

        if (acceso.getUsername().equals("admin") && acceso.getPassword().equals("1234")) {
            response.put("estado", "Acceso concedido");
        } else {
            response.put("estado", "Acceso denegado");
        }
        // response.put("datos", acceso);

        return response;
    }

    @PostMapping("/CrearUsuario")
    public Map<String, Object> CrearUsuario(@RequestBody Login acceso) {
        Map<String, Object> response = new HashMap<>();
        if (acceso.getUsername() != null && !acceso.getUsername().isEmpty() &&
            acceso.getPassword() != null && !acceso.getPassword().isEmpty()) {
            response.put("estado", "Usuario creado correctamente");
            response.put("datos", acceso);
        } else {
            response.put("estado", "Error al crear usuario: datos incompletos");
        }

        return response;
    }
    

      @PostMapping("/VerificarFormatoContrasena")
    public Map<String, Object> VerificarFormatoContraseña(@RequestBody Login acceso) {
        Map<String, Object> response = new HashMap<>();
        String password = acceso.getPassword();
        if (password != null && password.length() >= 8 && password.matches(".*[A-Z].*") &&
            password.matches(".*[a-z].*") && password.matches(".*\\d.*")) {
            response.put("estado", "Formato de contraseña válido");
        } else {
            response.put("estado", "Formato de contraseña inválido: debe tener al menos 8 caracteres, " +
                "una letra mayúscula, una letra minúscula y un número");
        }
        response.put("datos", acceso);
      
        return response;
    }

}
