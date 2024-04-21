package org.realestate;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class Application {

    @Transactional
    void onStart(@Observes StartupEvent event) {
        // Code to seed data into the database
        if (event.getClass().getSimpleName().equals("StartupEvent")) {
            System.out.println("The application is starting... ");
        }
    }
}