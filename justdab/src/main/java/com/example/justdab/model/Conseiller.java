package com.example.justdab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class Conseiller extends User {

    @OneToMany(targetEntity = Client.class)
    private List<Client> clients;


    //constructeurs
    public Conseiller (String nom, String email) {
        super(nom, email);
    }

    // Getters and setters
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}