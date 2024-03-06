package com.example.demo234.repository;

import com.example.demo234.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<EventEntity,Long> {
//    List<EventEntity> findByusername(String username) ;

//    Optional<Object> findAllById(Long id);

//    Optional<Object> findByuserId(Long userId);

    EventEntity findByDateCreated(LocalDateTime localDateTime);
}
