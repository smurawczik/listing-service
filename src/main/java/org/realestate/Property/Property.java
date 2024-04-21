package org.realestate.Property;

import java.time.LocalDate;
import java.util.List;

import org.realestate.Address.Address;
import org.realestate.Buyer.Buyer;
import org.realestate.Offer.Offer;
import org.realestate.PropertyType.PropertyType;
import org.realestate.RealEstateAgent.RealEstateAgent;
import org.realestate.RealEstateCompany.RealEstateCompany;
import org.realestate.Showing.Showing;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
  public LocalDate listedDate;

  // Relationships
  @OneToOne(cascade = CascadeType.ALL)
  public Address address;

  @ManyToOne(cascade = CascadeType.ALL)
  public RealEstateAgent listingAgent;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  public List<RealEstateAgent> sellingAgents;

  @ManyToOne(cascade = CascadeType.ALL)
  public RealEstateCompany realEstateCompany;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  public List<Buyer> interestedBuyers;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  public List<Offer> offers;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  public List<Showing> showings;

  // Other details
  @Enumerated(EnumType.STRING)
  public PropertyType type; // e.g., "Apartment", "House", "Condo", etc.
  public boolean isFeatured;
  public boolean isPetFriendly;
  public boolean hasGarage;
  public boolean hasPool;
  public int yearBuilt;
  public int numberOfFloors;
  public boolean hasBasement;
  public boolean hasAttic;
  public String flooring;
  public String heatingSystem;
  public String coolingSystem;
  public boolean hasFireplace;
  public boolean isGatedCommunity;
  public boolean hasSecuritySystem;
  public boolean hasWaterfront;
  public boolean hasCityView;
  public boolean hasMountainView;

  // Images and Features
  public List<String> images;
  public List<String> features;

  // Constructors, getters, and setters

  public Property() {
    // Default constructor
  }

  public Property(String title, String description, double price, int bedrooms, int bathrooms,
      double area, boolean isSold, LocalDate listedDate, Address address,
      RealEstateAgent listingAgent, List<RealEstateAgent> sellingAgents,
      RealEstateCompany realEstateCompany, List<Buyer> interestedBuyers,
      List<Offer> offers, List<Showing> showings, PropertyType type, boolean isFeatured,
      boolean isPetFriendly, boolean hasGarage, boolean hasPool, int yearBuilt,
      int numberOfFloors, boolean hasBasement, boolean hasAttic, String flooring,
      String heatingSystem, String coolingSystem, boolean hasFireplace,
      boolean isGatedCommunity, boolean hasSecuritySystem, boolean hasWaterfront,
      boolean hasCityView, boolean hasMountainView, List<String> images,
      List<String> features) {
    this.title = title;
    this.description = description;
    this.price = price;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.area = area;
    this.isSold = isSold;
    this.listedDate = listedDate;
    this.address = address;
    this.listingAgent = listingAgent;
    this.sellingAgents = sellingAgents;
    this.realEstateCompany = realEstateCompany;
    this.interestedBuyers = interestedBuyers;
    this.offers = offers;
    this.showings = showings;
    this.type = type;
    this.isFeatured = isFeatured;
    this.isPetFriendly = isPetFriendly;
    this.hasGarage = hasGarage;
    this.hasPool = hasPool;
    this.yearBuilt = yearBuilt;
    this.numberOfFloors = numberOfFloors;
    this.hasBasement = hasBasement;
    this.hasAttic = hasAttic;
    this.flooring = flooring;
    this.heatingSystem = heatingSystem;
    this.coolingSystem = coolingSystem;
    this.hasFireplace = hasFireplace;
    this.isGatedCommunity = isGatedCommunity;
    this.hasSecuritySystem = hasSecuritySystem;
    this.hasWaterfront = hasWaterfront;
    this.hasCityView = hasCityView;
    this.hasMountainView = hasMountainView;
    this.images = images;
    this.features = features;
  }
}
