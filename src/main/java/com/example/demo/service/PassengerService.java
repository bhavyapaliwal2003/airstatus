package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Passenger;
import com.example.demo.repository.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger registerPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger getPassengerById(String id) {
        return passengerRepository.findById(id).orElse(null); 
    }

    public Passenger updatePassenger(String id, Passenger updatedPassenger) {
        Passenger passenger = passengerRepository.findById(id).orElse(null);
        if (passenger != null) {
            passenger.setName(updatedPassenger.getName());
            passenger.setEmail(updatedPassenger.getEmail());
            passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
            return passengerRepository.save(passenger);
        } else {
            return null; 
        }
    }
    public String getFCMTokenForPassenger(String passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
        if (passenger != null) {
            return passenger.getFcmToken();
        } else {
            return null; 
        }
    }
}
