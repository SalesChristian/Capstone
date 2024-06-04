package org.example;

import org.example.config.MongoDBManager;
import org.example.model.Message;
import org.example.model.User;
import org.example.model.VacationRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapstoneApplication {
    public static void main(String[] args) {
        SpringApplication.run(CapstoneApplication.class, args);

        MongoDBManager.connect();

        User user = new User();
        user.setId("Id");
        user.setUsername("Username");
        user.setPassword("Password");
        MongoDBManager.saveUser(user);

        VacationRequest vacationRequest = new VacationRequest();

        vacationRequest.setStartDate("Startdatum");
        vacationRequest.setEndDate("Enddatum");
        MongoDBManager.saveVacationRequest(vacationRequest);

        Message message = new Message();
        message.setContent("Nachrichteninhalt");
        MongoDBManager.saveMessage(message);
    }
}
