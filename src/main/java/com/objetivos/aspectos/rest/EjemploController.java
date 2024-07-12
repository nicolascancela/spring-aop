package com.objetivos.aspectos.rest;

import com.objetivos.aspectos.domain.Persona;
import com.objetivos.aspectos.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploController {
    @Autowired
    private EjemploService ejemploService;

    @GetMapping("/ejemplo1")
    public String metodo(){
        return "Ejemplo 1";
    }

    @GetMapping("/ejemplo2")
    public String metodoDos(){
        ejemploService.metodoConUnStringYUnEntero("Parametro 1", 2);
        return "Ejemplo 2";
    }

    @GetMapping("/ejemplo3")
    public String metodoTres(){
        ejemploService.metodoConUnObjetoPersona();
        return "Ejemplo 3";
    }

    @GetMapping("/ejemplo4")
    public String metodoCuatro(){
        ejemploService.metodoQueDevuelveUnInteger(); //Match pointcut combinación.
        ejemploService.metodoQueDevuelveLong(); //Match pointcut combinación Service y Long.
        ejemploService.metodoQueDevuelveUnString(); //Match pointcut combinación.
        return "Ejemplo 4";
    }

    @GetMapping("/ejemplo5")
    public void metodoCinco(){
        System.out.println("Durante la ejecución del método");
    }

    @GetMapping("/ejemplo6")
    public void metodoSeis(@RequestParam String nombre, @RequestParam String apellido){
        System.out.println("Hola: "+nombre +" "+ apellido);
    }

    @GetMapping("/ejemplo6-a")
    public void metodoSeis(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer edad){
        System.out.println("Hola: "+nombre +" "+ apellido + "edad: "+ edad);
    }
}
