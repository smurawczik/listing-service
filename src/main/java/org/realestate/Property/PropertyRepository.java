package org.realestate.Property;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PropertyRepository implements PanacheMongoRepository<Property> {

  // put your custom logic here as instance methods

  public Property findByName(String name) {
    return find("name", name).firstResult();
  }

  public void deleteLoics() {
    delete("name", "Loïc");
  }
}