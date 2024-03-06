package com.example.demo234.repository;

import com.example.demo234.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<EventEntity, Long> {

    List<EventEntity> findAllByUsername(String username);
}
