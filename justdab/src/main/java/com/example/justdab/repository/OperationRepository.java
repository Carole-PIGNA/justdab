package com.example.justdab.repository;

import com.example.justdab.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByCompteBancaireId(Long compteBancaireId);
}