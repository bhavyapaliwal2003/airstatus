
package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org
.springframework.web.bind.annotation.*;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;

import java.util.List;
@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @PostMapping
public ResponseEntity<Flight> registerFlight(@RequestBody Flight newFlight) {
    return new ResponseEntity<>(flightRepository.save(newFlight), HttpStatus.CREATED);
}


    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    @GetMapping("/{flightId}") 
        public ResponseEntity<Flight> getFlightByFlightId(@PathVariable String flightId) { 
        Flight flight = flightRepository.findByFlightId(flightId);
        return flight != null ? ResponseEntity.ok(flight) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{flightId}") 
    public ResponseEntity<Flight> updateFlightStatus(@PathVariable String flightId, @RequestBody Flight updatedFlight) { 
        Flight flight = flightRepository.findByFlightId(flightId); 
        if (flight != null) {
            flight.setStatus(updatedFlight.getStatus()); 
            return ResponseEntity.ok(flightRepository.save(flight));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
