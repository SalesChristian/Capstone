package org.example.config;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.model.User;
import org.example.model.VacationRequest;
import org.example.model.Message;
import org.bson.types.ObjectId;

public class MongoDBManager {

    private static final String DATABASE_NAME = "capstone";
    private static MongoDatabase database;

    static {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        database = client.getDatabase(DATABASE_NAME);
    }
    public static void connect() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("capstone");
    }
    public static MongoCollection<Document> getUserCollection() {
        return database.getCollection("users");
    }

    public static MongoCollection<Document> getVacationRequestCollection() {
        return database.getCollection("vacationRequests");
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

    public static void saveVacationRequest(VacationRequest vacationRequest) {
        Document doc = new Document()
                .append("startDate", vacationRequest.getStartDate())
                .append("endDate", vacationRequest.getEndDate());
        if (vacationRequest.getId() != null) {
            doc.append("_id", new ObjectId(vacationRequest.getId()));
        }
        getVacationRequestCollection().insertOne(doc);
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
