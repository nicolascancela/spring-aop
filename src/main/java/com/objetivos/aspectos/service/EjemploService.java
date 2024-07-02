package com.objetivos.aspectos.service;

import com.objetivos.aspectos.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjemploService {

    @Autowired
    Persona persona;

    public void metodoConUnStringYUnEntero(String param1, int param2){
        System.out.println("Soy un método del service con: "+param1+ " y "+ param2);
    }

    public void metodoConUnObjetoPersona(){
        persona.saludar();
        System.out.println("Soy un método con una persona");
    }

    public Integer metodoQueDevuelveUnInteger(){
        System.out.println("Método que devuelve un Integer");
        return 1;
    }

    public String metodoQueDevuelveUnString(){
        System.out.println("Método que devuelve un String");
        return "String";
    }

    public Long metodoQueDevuelveLong(){
        System.out.println("Método que devuelve un Long");
        return Long.valueOf(1);
    }
}
