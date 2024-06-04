package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "messages")
public class Message {

    // Getters and Setters
    @Id
    private String id;
    private String senderId;
    private String receiverId;
    private String content;
    private String recipientId;

}
