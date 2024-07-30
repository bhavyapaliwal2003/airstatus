
package com.example.demo.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;




@Document("flights")
@Data
public class Flight {
    @Id
    private String id; 
    private String flightId; 
    private String airline;
    private String status;
    private String departureGate; 
    private String arrivalGate;
    private Date scheduledDeparture; 
    private Date scheduledArrival;
    private Date actualDeparture;
    private Date actualArrival; 
}


