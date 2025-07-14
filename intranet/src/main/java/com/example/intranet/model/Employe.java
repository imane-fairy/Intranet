package com.example.intranet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private String email;
  private int soldeConges;

  // getters et setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNom() { return nom; }
  public void setNom(String nom) { this.nom = nom; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public int getSoldeConges() { return soldeConges; }
  public void setSoldeConges(int soldeConges) { this.soldeConges = soldeConges; }
}
