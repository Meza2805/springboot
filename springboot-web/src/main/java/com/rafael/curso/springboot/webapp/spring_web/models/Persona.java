package com.rafael.curso.springboot.webapp.spring_web.models;

public class Persona {

    private String FirstName;
    private String LastName;

    public Persona (String FirstName, String LastName)
    {   
        this.FirstName = FirstName;
        this.LastName = LastName;
    }   

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
