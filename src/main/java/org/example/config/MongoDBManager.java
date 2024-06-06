package org.example.config;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.model.User;
import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MongoDBManager {

    private static final String DATABASE_NAME = "capstone";
    private static final MongoDatabase database;

    static {
        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            database = client.getDatabase(DATABASE_NAME);
        }
    }

    public static MongoCollection<Document> getUserCollection() {
        return database.getCollection("users");
    }

    public static MongoCollection<Document> getMessageCollection() {
        return database.getCollection("messages");
    }

    public static void saveUser(User user) {
        Document doc = new Document()
                .append("username", user.getUsername())
                .append("password", user.getPassword())
                .append("roles", user.getRoles());
        getUserCollection().insertOne(doc);
    }

    public static void saveMessage(Message message) {
        Document doc = new Document()
                .append("content", message.getContent());
        if (message.getId() != null) {
            doc.append("_id", new ObjectId(message.getId()));
        }
        getMessageCollection().insertOne(doc);
    }
}
