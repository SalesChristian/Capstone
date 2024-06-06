package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "vacations")
@Getter
@Setter
public class Vacation {
    @Id
    private String id;
    private String username;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    // Default constructor
    public Vacation() {
    }

    // Constructor with fields
    public Vacation(String username, LocalDate startDate, LocalDate endDate, String status) {
        this.username = username;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
