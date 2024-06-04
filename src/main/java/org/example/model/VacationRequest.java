package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "vacation_requests")
public class VacationRequest {

    // Getters and Setters
    @Id
    private String id;
    private String userId;
    private String vacationId;
    private String status;
    private String startDate;
    private String endDate;

}
