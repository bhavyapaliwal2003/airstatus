
package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("notifications")
@Data
public class Notification {
    @Id
    private String id;
    private String flightId; 
    private String message;
    private LocalDateTime timestamp;
    private String method;
    private String recipient; 
}
