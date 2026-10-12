package ro.example.lab1.exercise2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.example.lab1.exercise2.config.AppConfig;
import ro.example.lab1.exercise2.model.BankAccount;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            // DONE 4: Retrieve a BankAccount bean by type.
            // DONE 5: Display the account information.
            BankAccount mainAccount = context.getBean(BankAccount.class);
            mainAccount.displayAccountInfo();

            // DONE 6: Retrieve savingsAccount by name.
            BankAccount savingsAccount =
                    context.getBean("savingsAccount", BankAccount.class);
            savingsAccount.displayAccountInfo();
        }
    }
}
