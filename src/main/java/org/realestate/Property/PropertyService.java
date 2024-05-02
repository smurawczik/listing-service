package org.realestate.Property;

import java.util.List;
import java.util.stream.Collectors;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

public class PropertyService {

  public Uni<Property> createProperty(Property property) {
    property.setImages(
        property.getImages().stream().map(image -> image.concat(property.getTitle())).collect(Collectors.toList()));

    return Panache.withTransaction(property::persist).replaceWith(property);
  }

  public Uni<Property> getPropertyById(String id) {
    return Property.findById(Long.valueOf(id));
  }

  public Uni<List<Property>> getAllProperties() {
    return Property.findAll().list();
  }

  public Property updateProperty(String id, Property property) {
    Property existingProperty = this.getPropertyById(id).await().indefinitely();
    if (existingProperty != null) {
      if (property.getTitle() != null) {
        existingProperty.setTitle(property.getTitle());
      }
      if (property.getDescription() != null) {
        existingProperty.setDescription(property.getDescription());
      }
      if (Double.isFinite(property.getPrice())) {
        existingProperty.setPrice(property.getPrice());
      }
      if (property.getImages() != null) {
        existingProperty.setImages(property.getImages());
      }
      existingProperty.persist();
    }
    return existingProperty;
  }

  public void deleteProperty(int id) {
    Property.deleteById((long) id);
  }
}
