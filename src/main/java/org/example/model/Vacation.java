package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "vacations")
public class Vacation {

    // Getters and Setters
    @Id
    private String id;
    private String description;
    private String startDate;
    private String endDate;

}
