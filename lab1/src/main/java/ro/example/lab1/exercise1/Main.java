package ro.example.lab1.exercise1;

import ro.example.lab1.exercise1.notification.NotificationSender;
import ro.example.lab1.exercise1.notification.impl.SmsNotificationSender;
import ro.example.lab1.exercise1.service.NotificationService;

public class Main {

    public static void main(String[] args) {

        // DONE 2: Create the sender in Main
        // and inject it through the constructor.
        NotificationSender sender = new SmsNotificationSender();
        NotificationService service = new NotificationService(sender);
        service.notifyUser("Hello students!");

        // DONE 3: Create SmsNotificationSender
        // and switch from Email to SMS.
    }
}
