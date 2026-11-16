package ro.example.lab6.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Event {

    private Long id;
    // EXERCISE 3 - Input Validation

    // DONE: Add validation annotations:
    // - Name must not be null, empty, or blank.
    // - Name must have between 3 and 50 characters.
    @NotBlank(message = "Name must not be blank")
    @Size(
            min = 3,
            max = 50,
            message = "Name must be between 3 and 50 characters"
    )
    private String name;

    // DONE: Add validation annotation:
    // - Category must not be null, empty, or blank.
    @NotBlank(message = "Category must not be blank")
    private String category;

    public Event() {
    }

    public Event(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
