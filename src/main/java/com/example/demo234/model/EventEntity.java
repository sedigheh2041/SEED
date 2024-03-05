package com.example.demo234.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "EventEntity")
public class EventEntity {
    @Id
    @GeneratedValue
    long id;
    long userId;
    String  username;
    String type;
    long timestamp;
    String meta;
    boolean seen;
    @CreationTimestamp
    private LocalDateTime dateCreated;
}
