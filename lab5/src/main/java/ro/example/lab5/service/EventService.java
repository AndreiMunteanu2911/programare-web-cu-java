
package ro.example.lab5.service;

import org.springframework.stereotype.Service;
import ro.example.lab5.model.Event;

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


    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();

        for (Event event : events) {
            if (!categories.contains(event.getCategory())) {
                categories.add(event.getCategory());
            }
        }

        return categories;
    }

    public Event addEvent(Event event) {
        event.setId(nextId++);
        events.add(event);
        return event;
    }

    public Map<String, Integer> getSummary() {
        return Map.of(
                "totalEvents", events.size(),
                "totalCategories", getCategories().size()
        );
    }


    // EXERCISE 1 - Find event by ID
    public Event getEventById(Long id) {
        // DONE: Search for the event with the given ID.
        // DONE: Return the event if found, otherwise return null.
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }

        return null;
    }


    // EXERCISE 2 - Filter events by category
    public List<Event> getEventsByCategory(String category) {
        // DONE: Filter the events list by category.
        // DONE: Return only the events whose category matches.
        List<Event> filtered = new ArrayList<>();

        for (Event event : events) {
            if (event.getCategory().equals(category)) {
                filtered.add(event);
            }
        }

        return filtered;
    }

    // EXERCISE 4 - Update an event
    public Event updateEvent(Long id, Event updatedEvent) {
        // DONE: Find the event with the given ID.
        // DONE: Update its name and category.
        // DONE: Return the updated event.
        // DONE: Return null if the event doesn't exist.

        Event event = getEventById(id);

        if (event == null) {
            return null;
        }

        event.setName(updatedEvent.getName());
        event.setCategory(updatedEvent.getCategory());

        return event;
    }

    // EXERCISE 4 - Delete an event
    public boolean deleteEvent(Long id) {
        // DONE: Find the event with the given ID.
        // DONE: Remove it from the list.
        // DONE: Return true if deleted, false otherwise.

        return events.removeIf(event -> event.getId().equals(id));
    }

}
