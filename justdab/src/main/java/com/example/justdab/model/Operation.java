package com.example.justdab.model;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDateTime;


@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Double montant;
    private LocalDateTime dateOperation;

    @ManyToOne
    @JoinColumn(name = "compteBancaire_id")
    private CompteBancaire compteBancaire;

    public Operation() {}

    public Operation(String type, Double montant, CompteBancaire compteBancaire) {
        this.type = type;
        this.montant = montant;
        this.dateOperation = LocalDateTime.now();
        this.compteBancaire = compteBancaire;
    }

    // Getters et setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDateTime dateOperation) {
        this.dateOperation = dateOperation;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }
}