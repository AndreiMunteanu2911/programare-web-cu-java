
package ro.example.lab5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ro.example.lab5.model.Event;
import ro.example.lab5.service.EventService;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EventRestController {

    private final EventService eventService;

    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/events/summary")
    public Map<String, Integer> getSummary() {
        return eventService.getSummary();
    }


    // EXERCISE 1 - Get event by ID
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(
            // DONE: Add the annotation to extract the ID from the URL.
            @PathVariable Long id) {

        // DONE: Find the event using EventService.
        // DONE: Return 200 OK if found.
        // DONE: Return 404 Not Found otherwise.

        Event event = eventService.getEventById(id);

        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(event);
    }

    // EXERCISE 2 - Filter events by category
    @GetMapping("/events")
    public List<Event> getAllEvents(
            // DONE: Add the annotation for an optional query parameter.
            @RequestParam(required = false) String category) {

        if (category == null || category.isBlank()) {
            return eventService.getAllEvents();
        }

        // DONE: Return events filtered by category.
        return eventService.getEventsByCategory(category);
    }


    @GetMapping("/categories")
    public List<String> getCategories() {
        return eventService.getCategories();
    }

    // EXERCISE 3 - Create event using JSON
    @PostMapping(
            value = "/events",
            consumes = "application/json"
    )
    public ResponseEntity<Event> createEvent(
            // DONE: Add the annotation to read JSON
            // from the HTTP request body.
            @RequestBody Event event) {

        // DONE: Add the event using EventService.
        // DONE: Return 201 Created with the event.
        // DONE: Set the Location header to /api/events/{id}.

        Event created = eventService.addEvent(event);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    // EXERCISE 4 - Update an event
    @PutMapping(
            value = "/events/{id}",
            consumes = "application/json"
    )
    public ResponseEntity<Event> updateEvent(
            // DONE: Add the annotation to extract the ID from the URL.
            @PathVariable Long id,

            // DONE: Add the annotation to read the JSON request body.
            @RequestBody Event updatedEvent) {

        // DONE: Call EventService to update the event.
        // DONE: Return 200 OK with the updated event.
        // DONE: Return 404 Not Found if the event doesn't exist.

        Event event = eventService.updateEvent(id, updatedEvent);

        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(event);
    }


    // EXERCISE 4 - Delete an event
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(
            // DONE: Add the annotation to extract the ID from the URL.
            @PathVariable Long id) {

        // DONE: Call EventService to delete the event.
        // DONE: Return 204 No Content if deleted.
        // DONE: Return 404 Not Found otherwise.

        boolean deleted = eventService.deleteEvent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


    // EXERCISE 5 - Read HTTP Headers
    @GetMapping("/client-info")
    public Map<String, String> getClientInfo(
            // DONE: Add @RequestHeader to read "X-Client".
            // DONE: Use "unknown" as the default value.
            @RequestHeader(value = "X-Client", defaultValue = "unknown") String client) {

        // DONE: Return a Map containing:
        // "client" -> the received header value.

        return Map.of("client", client);
    }
}
