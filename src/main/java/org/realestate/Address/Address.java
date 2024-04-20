package org.realestate.Address;

public class Address {
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
