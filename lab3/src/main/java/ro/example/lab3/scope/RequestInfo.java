package ro.example.lab3.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
// DONE: Adaugati @RequestScope pentru a crea
// o instanta noua la fiecare cerere HTTP.
@RequestScope
public class RequestInfo {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
