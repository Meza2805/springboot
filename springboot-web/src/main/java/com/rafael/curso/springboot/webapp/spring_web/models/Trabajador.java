package com.rafael.curso.springboot.webapp.spring_web.models;

public class Trabajador extends Persona {

    private String NoSeguroSocial;

    public Trabajador(String FirstName, String LastName, String NoSeguroSocial) {
        super(FirstName, LastName);
        this.NoSeguroSocial = NoSeguroSocial;
        //TODO Auto-generated constructor stub
    }

    public String getNoSeguroSocial() {
        return NoSeguroSocial;
    }

    public void setNoSeguroSocial(String noSeguroSocial) {
        NoSeguroSocial = noSeguroSocial;
    }
}
