package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "users")
public class User {

    // Getters and Setters
    @Id
    private String id;
    private String username;
    private String password;
    private String[] roles;

}
