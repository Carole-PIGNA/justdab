package com.example.justdab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
public class Client extends User {

   @OneToMany(mappedBy = "client")
    private List<CompteBancaire> comptesBancaires;

    @ManyToOne
     @JoinColumn(name= "conseiller_id")

    private Conseiller conseiller;

    // Constructeur
    public Client(String nom, String email, Conseiller conseiller) {

        super(nom, email);
        this.conseiller = conseiller;
    }
    //getters et setters


   /* public Conseiller getConseiller() {
        return conseiller;
    }*/

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }
    public Conseiller getConseiller() {
        return  conseiller;
    }

    public List<CompteBancaire> getComptesBancaires() {
        return comptesBancaires;
    }

    public void setComptesBancaires(List<CompteBancaire> comptesBancaires) {
        this.comptesBancaires = comptesBancaires;
    }
}