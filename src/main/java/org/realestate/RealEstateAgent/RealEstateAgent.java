package org.realestate.RealEstateAgent;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class RealEstateAgent extends PanacheEntity {
  public String name;
  public String email;
  public String phoneNumber;

  // Constructors, getters, and setters

  public RealEstateAgent() {
    // Default constructor
  }

  public RealEstateAgent(String name, String email, String phoneNumber) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }
}
