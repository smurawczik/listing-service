package org.realestate.Address;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Address extends PanacheEntity {
  public String street;
  public String city;
  public String state;
  public String postalCode;
  public String country;

  public Address() {
    // Default constructor
  }

  public Address(String street, String city, String state, String postalCode, String country) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
  }
}
