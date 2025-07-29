package com.rafael.curso.springboot.webapp.spring_web.models;

public abstract class Animal {

    private String Nombre;

    public Animal ()
    {

    }
    
    public abstract String Avanzar();

     public String getNombre() {
         return Nombre;
     }

     public void setNombre(String nombre) {
         Nombre = nombre;
     }
}
