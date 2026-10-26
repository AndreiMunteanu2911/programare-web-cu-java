package ro.example.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.example.lab3.model.Event;
import ro.example.lab3.service.EventService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String showEvents(Model model) {

        // DONE 1: Obtineti lista evenimentelor din EventService.
        List<Event> events = eventService.getAllEvents();

        // DONE 2: Adaugati lista in Model cu numele "events".
        model.addAttribute("events", events);

        return "events";
    }


    @GetMapping("/events/new")
    public String showAddEventForm(Model model) {

        model.addAttribute("event", new Event());

        return "event-form";
    }

    // DONE 3: Adaugati @PostMapping pentru ruta /events
    @PostMapping("/events")
    public String addEvent(
            // DONE 4: Folositi @ModelAttribute
            @ModelAttribute("event")
            Event event) {

        // DONE 5: Apelati eventService.addEvent(event)
        eventService.addEvent(event);

        return "redirect:/events";
    }

}
