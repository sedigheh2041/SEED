package com.example.demo234.service;

import com.example.demo234.model.EventEntity;
import com.example.demo234.repository.EventsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventsService {

    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<EventEntity> findAll() {
        return eventsRepository.findAll();
    }

    public List<EventEntity> findAllByUsername(String username) {
        return eventsRepository.findAllByUsername(username);
    }
}