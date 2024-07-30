package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Flight;
@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {
    Flight findByFlightId(String flightId);  
}