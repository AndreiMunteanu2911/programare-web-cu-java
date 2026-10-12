package ro.example.lab1.exercise3.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    // DONE 1: Add @Component.

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
