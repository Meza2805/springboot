package com.rafael.curso.springboot.webapp.spring_web.models;

public class Estudiante  extends Persona{

    private String NoCarnet;
    private String Curso;

    public Estudiante(String FirstName, String LastName,String NoCarnet, String Curso) {
        super(FirstName, LastName);
        this.Curso = Curso;
        this.NoCarnet = NoCarnet;
    }
    
   public String getCurso() {
       return Curso;
   }

   public String getNoCarnet() {
       return NoCarnet;
   }

   public void setCurso(String curso) {
       Curso = curso;
   }

   public void setNoCarnet(String noCarnet) {
       NoCarnet = noCarnet;
   }
}
