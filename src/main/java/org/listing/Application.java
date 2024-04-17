package org.listing;

import java.time.LocalDate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class Application {

    @Inject
    MongoClient mongoClient;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        // Code to seed data into the database
        if (event.getClass().getSimpleName().equals("StartupEvent")) {
            System.out.println("The application is starting... ");

            MongoDatabase database = mongoClient.getDatabase("fruit");

            // Drop the collection containing the records
            database.getCollection("fruit").drop();
        }
    }
}