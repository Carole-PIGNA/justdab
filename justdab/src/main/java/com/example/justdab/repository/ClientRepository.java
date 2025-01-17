package com.example.justdab.repository;

import com.example.justdab.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByConseiller(Conseiller conseiller);
}