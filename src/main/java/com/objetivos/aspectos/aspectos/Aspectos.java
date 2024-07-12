package com.objetivos.aspectos.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspectos {

    //Execution: Matchea un método particular en una clase particular.
    @Before("execution(public String com.objetivos.aspectos.rest.EjemploController.metodo())")
    public void antesDelMetodoEspecifico(){
        System.out.println("Match método especifico");
    }

    @After("execution(public String com.objetivos.aspectos.rest.EjemploController.metodo())")
    public void despuesDelMetodoEspecifico(){
        System.out.println("Match método especifico después de su ejecución");
    }

    @Before("execution(public * com.objetivos.aspectos.rest.EjemploController.metodo())")
    public void antesDelMetodoQueDevuelveCualquierCosa(){
        System.out.println("Match método que devuelve cualquier cosa");
    }

    @Before("execution(String com.objetivos.aspectos.rest.EjemploController.metodo())")
    public void antesDelMetodoQueTieneCualquierModificadorDeAcceso(){
        System.out.println("Match método que tiene cualquier modificador de acceso");
    }

    @Before("execution(String com.objetivos.aspectos.rest.EjemploController.*())")
    public void antesDeCualquierMetodoClaseEjemploController(){
        System.out.println("Match cualquier metodo clase EjemploController");
    }

    @Before("execution(public String com.objetivos.aspectos.rest.EjemploController.*())")
    public void antesDeCualquierMetodoPublicoClaseEjemploController(){
        System.out.println("Match cualquier metodo público clase EjemploController");
    }

    @Before("execution(private String com.objetivos.aspectos.rest.EjemploController.*())")
    public void antesDeCualquierMetodoPrivadoClaseEjemploController(){
        System.out.println("Match cualquier metodo privado clase EjemploController");
    }

    @Before("within(com.objetivos.aspectos.rest.EjemploController)")
    public void antesDeCualquierMetodoDeLaClaseEjemploController(){
        System.out.println("Match cualquier metodo de la clase EjemploController");
    }

    //within: Matchea todos los métodos de una clase o un paquete.
    @Before("within(com.objetivos..*)")
    public void antesDeCualquierMetodoDelasClasesDentroDePaqueteObjetivos(){
        System.out.println("Match cualquier metodo de las clases dentro del paquete objetivos");
    }

    //@within: Matchea cualquier método en una clase que tiene una anotación.
    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void antesDeCualquierMetodoDelasClasesConAnotacionRestController(){
        System.out.println("Match cualquier metodo de las clases con anotacion RestController");
    }

    //annotation: Cualquier método que tiene una anotación
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void antesDeCualquierMetodoConAnotacionGetMapping(){
        System.out.println("Match cualquier metodo con anotacion GetMapping");
    }

    //args: Matchea cualquier método con argumentos
    @Before("args(String,int)")
    public void antesDeCualquierMetodoConUnArgumentoStringYUnInt(){
        System.out.println("Match cualquier metodo con un argumento  y un int");
    }

    /*@Before("args(org.springframework.stereotype.Component)")
    public void antesDeCualquierMetodoConUnArgumentoQueTengaUnaAnotacion(){
        System.out.println("Match cualquier metodo con un Component como parámetro");
    }*/

    /*@Before("args(com.objetivos.aspectos.domain.Persona)")
    public void antesDeCualquierMetodoConUnArgumentoPersona(){
        System.out.println("Match cualquier metodo con un argumento personalizado Persona");
    }*/

    //target: Matchea cualquier método de instancia de una clase
    //Obs: Solo se aplican aspectos a las instancias creadas por SpringBoot.
    @Before("target(com.objetivos.aspectos.domain.Persona)")
    public void antesDeCualquierMetodoLaClasePersona(){
        System.out.println("Match cualquier metodo de instancia de la clase Persona");
    }

    //Combinación de pointcuts
    @Before("execution(String com.objetivos.aspectos.service.EjemploService.*()) || execution(Integer com.objetivos.aspectos.service.EjemploService.*())")
    public void antesDeCualquierMetodoQueDevuelvaUnStringOUnInteger(){
        System.out.println("Match cualquier metodo de Ejemplo Service que devuelva un String o un Integer");
    }

    //Combinación de pointcuts
    @Before("@within(org.springframework.stereotype.Service) && execution(Long com.objetivos.aspectos.service.EjemploService.*())")
    public void antesDeCualquierMetodoDeUnaClaseQueTengaUnaAnotacionServiceYDevuelvaUnLong(){
        System.out.println("Match cualquier metodo de una clase que tenga una anotacion Service y devuelva un Long");
    }

    //Pointcuts con nombre
    @Pointcut("@within(org.springframework.stereotype.Component)")
    public void pointCuitConNombre(){
        //Se deja el método vacío.
    }

    @Before("pointCuitConNombre()")
    public void antesDeCualquierMetodoPointCutPersonalizado(){
        System.out.println("POINTCUT Personalizado --> Cualquier método de una clase anotada por Component");
    }

    @Around("execution(public void com.objetivos.aspectos.rest.EjemploController.metodoCinco())")
    public void antesYdespuesDelMetodoEspecifico(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Antes de la ejecución del método");
        joinPoint.proceed(); //Ejecución del método, sino lo invoco el método no se ejecuta.
        System.out.println("Después de la ejecución del método");
    }

    @After("execution(public void com.objetivos.aspectos.rest.EjemploController.metodoSeis(*,*))")
    public void despuesDelMetodoSeisConDosParametros(JoinPoint joinPoint) throws Throwable {
        Object[] argumentos = joinPoint.getArgs();
        for (Object arg : argumentos) {
            if (arg != null) {
                System.out.println("Tipo: " + arg.getClass().getSimpleName() + ", Valor: " + arg.toString());
            } else {
                System.out.println("Tipo: null, Valor: null");
            }
        }
        System.out.println("Match con método con dos parámetros");
    }

    @After("execution(public void com.objetivos.aspectos.rest.EjemploController.metodoSeis(..))")
    public void despuesDelMetodoSeisConNParametros(JoinPoint joinPoint) throws Throwable {
        Object[] argumentos = joinPoint.getArgs();
        for (Object arg : argumentos) {
            if (arg != null) {
                System.out.println("Tipo: " + arg.getClass().getSimpleName() + ", Valor: " + arg.toString());
            } else {
                System.out.println("Tipo: null, Valor: null");
            }
        }
        System.out.println("Match con método con n parámetros");
    }
}
