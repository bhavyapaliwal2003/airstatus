package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("passengers")
@Data
public class Passenger {
    @Id
    private String id; 
    private String name;
    private String email;
    private String phoneNumber;
    private String flightNumber; 
    private String fcmToken; 
    
}

