package com.example.justdab.model;

import jakarta.persistence.*;
import java.util.List;

public class Conseiller extends User {

    @OneToMany(mappedBy = "conseiller")
    private List<Client> clients;

    // Getters and setters


    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}