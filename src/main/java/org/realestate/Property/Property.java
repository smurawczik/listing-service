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
  private String title;
  private String description;
  private double price;
  private int bedrooms;
  private int bathrooms;
  private double area; // in square feet
  private boolean isSold;
  private LocalDate listedDate;

  // Relationships
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  @ManyToOne(cascade = CascadeType.ALL)
  private RealEstateAgent listingAgent;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<RealEstateAgent> sellingAgents;

  @ManyToOne(cascade = CascadeType.ALL)
  private RealEstateCompany realEstateCompany;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Buyer> interestedBuyers;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Offer> offers;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Showing> showings;

  // Other details
  @Enumerated(EnumType.STRING)
  private PropertyType type; // e.g., "Apartment", "House", "Condo", etc.
  private boolean isFeatured;
  private boolean isPetFriendly;
  private boolean hasGarage;
  private boolean hasPool;
  private int yearBuilt;
  private int numberOfFloors;
  private boolean hasBasement;
  private boolean hasAttic;
  private String flooring;
  private String heatingSystem;
  private String coolingSystem;
  private boolean hasFireplace;
  private boolean isGatedCommunity;
  private boolean hasSecuritySystem;
  private boolean hasWaterfront;
  private boolean hasCityView;
  private boolean hasMountainView;

  private List<String> images;
  private List<String> features;

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

  // Getters and Setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(int bedrooms) {
    this.bedrooms = bedrooms;
  }

  public int getBathrooms() {
    return bathrooms;
  }

  public void setBathrooms(int bathrooms) {
    this.bathrooms = bathrooms;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }

  public boolean isSold() {
    return isSold;
  }

  public void setSold(boolean isSold) {
    this.isSold = isSold;
  }

  public LocalDate getListedDate() {
    return listedDate;
  }

  public void setListedDate(LocalDate listedDate) {
    this.listedDate = listedDate;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public RealEstateAgent getListingAgent() {
    return listingAgent;
  }

  public void setListingAgent(RealEstateAgent listingAgent) {
    this.listingAgent = listingAgent;
  }

  public List<RealEstateAgent> getSellingAgents() {
    return sellingAgents;
  }

  public void setSellingAgents(List<RealEstateAgent> sellingAgents) {
    this.sellingAgents = sellingAgents;
  }

  public RealEstateCompany getRealEstateCompany() {
    return realEstateCompany;
  }

  public void setRealEstateCompany(RealEstateCompany realEstateCompany) {
    this.realEstateCompany = realEstateCompany;
  }

  public List<Buyer> getInterestedBuyers() {
    return interestedBuyers;
  }

  public void setInterestedBuyers(List<Buyer> interestedBuyers) {
    this.interestedBuyers = interestedBuyers;
  }

  public List<Offer> getOffers() {
    return offers;
  }

  public void setOffers(List<Offer> offers) {
    this.offers = offers;
  }

  public List<Showing> getShowings() {
    return showings;
  }

  public void setShowings(List<Showing> showings) {
    this.showings = showings;
  }

  public PropertyType getType() {
    return type;
  }

  public void setType(PropertyType type) {
    this.type = type;
  }

  public boolean isFeatured() {
    return isFeatured;
  }

  public void setFeatured(boolean isFeatured) {
    this.isFeatured = isFeatured;
  }

  public boolean isPetFriendly() {
    return isPetFriendly;
  }

  public void setPetFriendly(boolean isPetFriendly) {
    this.isPetFriendly = isPetFriendly;
  }

  public boolean isHasGarage() {
    return hasGarage;
  }

  public void setHasGarage(boolean hasGarage) {
    this.hasGarage = hasGarage;
  }

  public boolean isHasPool() {
    return hasPool;
  }

  public void setHasPool(boolean hasPool) {
    this.hasPool = hasPool;
  }

  public int getYearBuilt() {
    return yearBuilt;
  }

  public void setYearBuilt(int yearBuilt) {
    this.yearBuilt = yearBuilt;
  }

  public int getNumberOfFloors() {
    return numberOfFloors;
  }

  public void setNumberOfFloors(int numberOfFloors) {
    this.numberOfFloors = numberOfFloors;
  }

  public boolean isHasBasement() {
    return hasBasement;
  }

  public void setHasBasement(boolean hasBasement) {
    this.hasBasement = hasBasement;
  }

  public boolean isHasAttic() {
    return hasAttic;
  }

  public void setHasAttic(boolean hasAttic) {
    this.hasAttic = hasAttic;
  }

  public String getFlooring() {
    return flooring;
  }

  public void setFlooring(String flooring) {
    this.flooring = flooring;
  }

  public String getHeatingSystem() {
    return heatingSystem;
  }

  public void setHeatingSystem(String heatingSystem) {
    this.heatingSystem = heatingSystem;
  }

  public String getCoolingSystem() {
    return coolingSystem;
  }

  public void setCoolingSystem(String coolingSystem) {
    this.coolingSystem = coolingSystem;
  }

  public boolean isHasFireplace() {
    return hasFireplace;
  }

  public void setHasFireplace(boolean hasFireplace) {
    this.hasFireplace = hasFireplace;
  }

  public boolean isGatedCommunity() {
    return isGatedCommunity;
  }

  public void setGatedCommunity(boolean isGatedCommunity) {
    this.isGatedCommunity = isGatedCommunity;
  }

  public boolean isHasSecuritySystem() {
    return hasSecuritySystem;
  }

  public void setHasSecuritySystem(boolean hasSecuritySystem) {
    this.hasSecuritySystem = hasSecuritySystem;
  }

  public boolean isHasWaterfront() {
    return hasWaterfront;
  }

  public void setHasWaterfront(boolean hasWaterfront) {
    this.hasWaterfront = hasWaterfront;
  }

  public boolean isHasCityView() {
    return hasCityView;
  }

  public void setHasCityView(boolean hasCityView) {
    this.hasCityView = hasCityView;
  }

  public boolean isHasMountainView() {
    return hasMountainView;
  }

  public void setHasMountainView(boolean hasMountainView) {
    this.hasMountainView = hasMountainView;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public List<String> getFeatures() {
    return features;
  }

  public void setFeatures(List<String> features) {
    this.features = features;
  }
}
