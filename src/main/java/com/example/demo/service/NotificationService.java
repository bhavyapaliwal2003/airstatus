package com.example.demo.service;


import com.example.demo.entity.Passenger;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ... other imports

@Service
public class NotificationService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Autowired
    private PassengerService passengerService;
    public void sendNotification(String passengerId, String message) {
        Passenger passenger = passengerService.getPassengerById(passengerId);
        if (passenger == null || passenger.getFcmToken() == null) {
            // Handle the case where the passenger or FCM token is missing
            // You can log an error or throw an exception
            System.err.println("Passenger or FCM token not found for passenger ID: " + passengerId);
            return; 
        }
        String token = passenger.getFcmToken();
        // 2. Build the notification message
        Notification notification = Notification.builder()
                .setTitle("Flight Status Update")
                .setBody(message)
                .build();
        Message fcmMessage = Message.builder()
                .setToken(token)
                .setNotification(notification)
                .build();
       
        try {
            firebaseMessaging.send(fcmMessage);
        } catch (Exception e) {
          
        }
    }

   
}
