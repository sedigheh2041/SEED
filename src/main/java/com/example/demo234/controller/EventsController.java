package com.example.demo234.controller;

import com.example.demo234.model.EventEntity;
import com.example.demo234.service.EventsService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Data
@RestController
@RequestMapping("/")

public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping
    public List<EventEntity> getAllEvents() {
        return eventsService.findAll();
    }

    @GetMapping("{username}")
    public List<EventEntity> getEventsByUsername(@PathVariable String username) {
        return eventsService.findAllByUsername(username);
    }
    @GetMapping("{id}")
    public Optional<EventEntity> getEventById(@PathVariable Long id) {
        return eventsService.findEventById(id);
    }
    @GetMapping("{timestamp}")
    public List<EventEntity> getEventByTime(@PathVariable Long timestamp){
        return  eventsService.findEventByTimestamp(timestamp);
    }
    @PostMapping
    public void saveEntitys(@RequestBody EventEntity event){
         eventsService.saveEvent(event);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        eventsService.deleteUser(id);
    }
}