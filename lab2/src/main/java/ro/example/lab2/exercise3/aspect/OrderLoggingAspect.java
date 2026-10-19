package ro.example.lab2.exercise3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
@Component
public class OrderLoggingAspect {

    @Pointcut("execution(* ro.example.lab2.exercise3.service.OrderService.placeOrder(..))")
    public void orderMethods() {
    }

    @Before("orderMethods()")
    public void logBefore() {
        System.out.println("[AOP] Before: Placing order...");
    }

    // DONE 1: Implementati @AfterReturning
    // Afisati un mesaj cand comanda este procesata cu succes.
    // Indiciu: folositi atributul returning pentru a obtine rezultatul.
    @AfterReturning(pointcut = "orderMethods()", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("[AOP] Success: " + result);
    }

    // DONE 2: Implementati @AfterThrowing
    // Afisati mesajul exceptiei atunci cand plasarea comenzii esueaza.
    @AfterThrowing(pointcut = "orderMethods()", throwing = "exception")
    public void logAfterThrowing(IllegalArgumentException exception) {
        System.out.println("[AOP] Error: " + exception.getMessage());
    }

    // DONE 3: Implementati @After
    // Afisati un mesaj la finalul metodei,
    // indiferent daca metoda reuseste sau arunca o exceptie.
    @After("orderMethods()")
    public void logAfter() {
        System.out.println("[AOP] Finished processing order.");
    }

    // DONE 4 (BONUS): Implementati @Around
    // Masurati durata executiei folosind System.nanoTime().
    // Nu uitati sa apelati proceed()!
    @Around("orderMethods()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long duration = System.nanoTime() - startTime;
            System.out.println("[AOP] Execution time: " + duration + " ns");
        }
    }
}
