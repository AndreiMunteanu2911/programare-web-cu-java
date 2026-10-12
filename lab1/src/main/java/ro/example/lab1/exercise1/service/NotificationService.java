package ro.example.lab1.exercise1.service;

import ro.example.lab1.exercise1.notification.NotificationSender;

public class NotificationService {

    private final NotificationSender sender;

    // DONE 1: Replace tight coupling with constructor injection.
    // Depend on NotificationSender instead of EmailNotificationSender.
    public NotificationService(NotificationSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String message) {
        sender.send(message);
    }
}
