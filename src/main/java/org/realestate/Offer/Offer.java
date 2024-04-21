package org.realestate.Offer;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Offer extends PanacheEntity {
  public double amount;
  public boolean isAccepted;

  // Constructors, getters, and setters

  public Offer() {
    // Default constructor
  }

  public Offer(double amount, boolean isAccepted) {
    this.amount = amount;
    this.isAccepted = isAccepted;
  }
}
