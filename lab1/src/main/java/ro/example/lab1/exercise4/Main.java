package ro.example.lab1.exercise4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.example.lab1.exercise4.config.AppConfig;
import ro.example.lab1.exercise4.service.NotificationService;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            // DONE 7: Retrieve NotificationService from Spring.
            NotificationService notificationService =
                    context.getBean(NotificationService.class);

            // DONE 8: Send "Hello students!".
            notificationService.notifyUser("Hello students!");
        }
    }
}
