package ro.example.lab1.exercise3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.example.lab1.exercise3.config.AppConfig;
import ro.example.lab1.exercise3.service.GreetingService;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            // DONE 3: Retrieve GreetingService from Spring.
            GreetingService greetingService = context.getBean(GreetingService.class);

            // DONE 4: Print greet("students").
            System.out.println(greetingService.greet("students"));
        }
    }
}
