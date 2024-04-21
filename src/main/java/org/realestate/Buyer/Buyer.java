package org.realestate.Buyer;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Buyer extends PanacheEntity {
  public String name;
  public String email;
  public String phoneNumber;

  // Constructors, getters, and setters

  public Buyer() {
    // Default constructor
  }

  public Buyer(String name, String email, String phoneNumber) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }
}
