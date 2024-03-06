package com.example.demo234.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table
public class EventEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String username;
    private String type;
    private Long timestamp;
    private String meta;
    private Boolean seen;
    @CreationTimestamp
    private LocalDateTime dateCreated;
}
