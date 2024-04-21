package org.realestate.Property;

import org.realestate.Address.Address;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
@Cacheable
public class Property extends PanacheEntity {
  public String title;
  public String description;
  public double price;
  public int bedrooms;
  public int bathrooms;
  public double area; // in square feet
  public boolean isSold;
  @OneToOne(cascade = CascadeType.ALL)
  public Address address;
  // Constructors, getters, and setters

  public Property() {
    // Default constructor
  }

  public Property(String title, String description, double price, int bedrooms, int bathrooms,
      double area, boolean isSold, Address address) {
    this.title = title;
    this.description = description;
    this.price = price;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.area = area;
    this.isSold = isSold;
    this.address = address;
  }
}
