package org.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String sender;
    private String recipient;
    private String content;

    public Message() {}

    public Message(String sender, String recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }
}
