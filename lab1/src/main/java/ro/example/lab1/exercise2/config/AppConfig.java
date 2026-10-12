package ro.example.lab1.exercise2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ro.example.lab1.exercise2.model.BankAccount;

@Configuration
public class AppConfig {

    // DONE 1: Define a BankAccount bean using @Bean.
    // Account: RO123456, Andrei, 1500.0
    @Bean
    @Primary
    public BankAccount mainAccount() {
        return new BankAccount("RO123456", "Andrei", 1500.0);
    }

    // DONE 2: Define another bean called savingsAccount.
    // Account: RO987654, Maria, 5000.0
    @Bean
    public BankAccount savingsAccount() {
        return new BankAccount("RO987654", "Maria", 5000.0);
    }

    // DONE 3: Use @Primary to select the default bean.
}
