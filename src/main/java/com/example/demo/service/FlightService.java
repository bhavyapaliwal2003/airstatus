package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;

import java.util.List;

@Service
public class FlightService
 {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightId(flightNumber);
    }

    public Flight updateFlightStatus(String flightNumber, Flight updatedFlight) {
        Flight flight = flightRepository.findByFlightId(flightNumber);
        if (flight != null) {
            flight.setStatus(updatedFlight.getStatus());
            return flightRepository.save(flight); 
        } else {
            return null; 
        }
    }

    
}

