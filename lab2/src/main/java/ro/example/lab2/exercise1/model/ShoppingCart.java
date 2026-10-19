package ro.example.lab2.exercise1.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype") // DONE 1: Schimbati scope-ul in prototype
public class ShoppingCart {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
