package org.realestate.Property;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "properties")
public class Property {
  public ObjectId id;
  public String title;
  public String description;
  public double price;
  public int bedrooms;
  public int bathrooms;
  public double area; // in square feet
  public boolean isSold;

  // Constructors, getters, and setters

  public Property() {
    // Default constructor
  }

  public Property(String title, String description, double price, int bedrooms, int bathrooms,
      double area, boolean isSold) {
    this.title = title;
    this.description = description;
    this.price = price;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.area = area;
    this.isSold = isSold;
  }
}
