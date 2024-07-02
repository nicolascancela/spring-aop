package com.objetivos.aspectos.rest;

import com.objetivos.aspectos.domain.Persona;
import com.objetivos.aspectos.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploController {
    @Autowired
    private EjemploService ejemploService;

    @GetMapping("/ejemplo")
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
        ejemploService.metodoQueDevuelveLong(); //No matchea con ningún pointcut.
        ejemploService.metodoQueDevuelveUnString(); //Match pointcut combinación.
        return "Ejemplo 4";
    }
}
