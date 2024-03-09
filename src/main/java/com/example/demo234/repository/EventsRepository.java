package com.example.demo234.repository;

import com.example.demo234.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventsRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findAllByUsername(String username);

    Optional<EventEntity> findById(Long id);

//    @Query("select * from EventEntity  where timestamp=timestamp")
    List<EventEntity> findByTimestamp(Long timestamp);
}