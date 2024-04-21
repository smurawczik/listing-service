package org.realestate.Showing;

import java.time.LocalDateTime;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Showing extends PanacheEntity {
  public LocalDateTime dateTime;
  public boolean isConfirmed;

  // Constructors, getters, and setters

  public Showing() {
    // Default constructor
  }

  public Showing(LocalDateTime dateTime, boolean isConfirmed) {
    this.dateTime = dateTime;
    this.isConfirmed = isConfirmed;
  }
}
