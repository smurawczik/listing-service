package org.realestate.RealEstateCompany;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class RealEstateCompany extends PanacheEntity {
  public String name;
  public String address;
  public String phoneNumber;

  // Constructors, getters, and setters

  public RealEstateCompany() {
    // Default constructor
  }

  public RealEstateCompany(String name, String address, String phoneNumber) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }
}
