package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Passenger;
import com.example.demo.repository.PassengerRepository;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerRepository passengerRepository;
    
    @PostMapping
    public ResponseEntity<Passenger> registerPassenger(@RequestBody Passenger passenger) {
        return new ResponseEntity<>(passengerRepository.save(passenger), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable String id) {
        return passengerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable String id, @RequestBody Passenger updatedPassenger) {
        return passengerRepository.findById(id)
                .map(passenger -> {
                    
                    passenger.setName(updatedPassenger.getName());
                    passenger.setEmail(updatedPassenger.getEmail());
                    passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
                    return ResponseEntity.ok(passengerRepository.save(passenger));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
