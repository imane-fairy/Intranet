package com.example.intranet.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private TypeConge typeConge;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    private String statut; // ex: "En attente", "Accepté", "Refusé"

  // getters et setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Employe getEmploye() { return employe; }
  public void setEmploye(Employe employe) { this.employe = employe; }
  public TypeConge getTypeConge() { return typeConge; }
  public void setTypeConge(TypeConge typeConge) { this.typeConge = typeConge; }
  public LocalDate getDateDebut() { return dateDebut; }
  public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
  public LocalDate getDateFin() { return dateFin; }
  public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
  public String getStatut() { return statut; }
  public void setStatut(String statut) { this.statut = statut; }
}
