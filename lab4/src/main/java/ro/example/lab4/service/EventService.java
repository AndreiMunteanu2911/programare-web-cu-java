
package ro.example.lab4.service;

import org.springframework.stereotype.Service;
import ro.example.lab4.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private Long nextId = 4L;

    public EventService() {
        events.add(new Event(1L, "Java Workshop", "Technology"));
        events.add(new Event(2L, "Spring Boot Lab", "Education"));
        events.add(new Event(3L, "REST Workshop", "Technology"));
    }

    public List<Event> getAllEvents() {
        return events;
    }

    // EXERCISE 2
    public List<String> getCategories() {
        // DONE: Return all distinct event categories.
        return events.stream()
                .map(Event::getCategory)
                .distinct()
                .toList();
    }

    // EXERCISE 3
    public Event addEvent(Event event) {
        // DONE: Assign a unique ID to the new event.
        event.setId(nextId++);

        // DONE: Add the event to the list.
        events.add(event);

        // DONE: Return the created event.
        return event;
    }

    // EXERCISE 4
    public Map<String, Integer> getSummary() {
        // DONE: Return a map containing:
        // "totalEvents" - number of events
        // "totalCategories" - number of distinct categories
        return Map.of(
                "totalEvents", events.size(),
                "totalCategories", getCategories().size()
        );
    }
}
