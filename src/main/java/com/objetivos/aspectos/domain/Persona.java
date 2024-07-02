package com.objetivos.aspectos.domain;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    private String nombre;
    private String apellido;

    public Persona(){
        this.nombre ="Nombre";
        this.apellido = "Apellido";
    }

    public void saludar(){
        System.out.println("Hola!");
    }
}
