package com.example.justdab.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client extends User {
   @OneToMany(mappedBy = "client")
    private List<CompteBancaire> comptesBancaires;

    @ManyToOne
     @JoinColumn(name= "conseiller_id")
    private Conseiller conseiller;
    //getters et setters


    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public List<CompteBancaire> getComptesBancaires() {
        return comptesBancaires;
    }

    public void setComptesBancaires(List<CompteBancaire> comptesBancaires) {
        this.comptesBancaires = comptesBancaires;
    }
}