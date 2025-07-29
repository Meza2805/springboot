package com.rafael.curso.springboot.webapp.spring_web.models;

public class AnimalTerrestre extends Animal{


    private String Especie;
    private String Tipo;

    @Override
    public String Avanzar() {
        return "Corriendo";
    }
    
    

}
