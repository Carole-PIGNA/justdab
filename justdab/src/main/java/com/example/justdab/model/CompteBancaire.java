package com.example.justdab.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CompteBancaire {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "client_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(updatable = false)
    private Long id;
    private Double solde;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "client_id")
    private Client client;


    public CompteBancaire() {
    }

    public CompteBancaire(Double solde, Long id) {
        this.solde = solde;
        this.id = id;


    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}