package ro.example.lab1.exercise4.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.example.lab1.exercise4.notification.NotificationSender;

// DONE 3: Add @Service.
@Service
public class NotificationService {

    private final NotificationSender sender;

    // DONE 4: Let Spring inject the dependency.
    // DONE 5: Use @Qualifier to choose emailSender.

    public NotificationService(@Qualifier("emailSender") NotificationSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String message) {
        sender.send(message);
    }
}
