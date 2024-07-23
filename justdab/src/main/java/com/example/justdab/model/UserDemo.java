package com.example.justdab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserDemo", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
public class UserDemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    @NonNull
    private String nom;
    @Column(columnDefinition = "TEXT")
    @NonNull
    private String email;

    public UserDemo(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
}
