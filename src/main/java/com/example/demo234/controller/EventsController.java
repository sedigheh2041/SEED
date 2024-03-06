package com.example.demo234.controller;

import com.example.demo234.model.EventEntity;
import com.example.demo234.service.EventsService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}