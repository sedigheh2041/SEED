package com.example.demo234.service;

import com.example.demo234.model.EventEntity;
import com.example.demo234.repository.EventsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.runAsync;

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
    public Optional<EventEntity> findEventById(Long id) {
        return eventsRepository.findById(id);
    }
    public List <EventEntity> findEventByTimestamp(Long timestamp){
        return eventsRepository.findByTimestamp(timestamp);}

    public EventEntity saveEvent(EventEntity event) {
        return eventsRepository.save(event);
    }

    public void deleteUser(Long id) {
        eventsRepository.deleteById(id);
    }


}