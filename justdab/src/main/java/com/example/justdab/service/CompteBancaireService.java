package com.example.justdab.service;

import com.example.justdab.model.CompteBancaire;
import com.example.justdab.model.Operation;
import com.example.justdab.repository.CompteBancaireRepository;
import com.example.justdab.repository.OperationRepository;
import com.example.justdab.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteBancaireService {

    @Autowired
    private CompteBancaireRepository compteBancaireRepository;

    @Autowired
    private OperationRepository operationRepository;

    public Double consulterSolde(Long compteId) {
        CompteBancaire compte = compteBancaireRepository.findById(compteId)
                .orElseThrow(() -> new ResourceNotFoundException("Compte not found"));
        return compte.getSolde();
    }

    public void depot(Long compteId, Double montant) {
        CompteBancaire compte = compteBancaireRepository.findById(compteId)
                .orElseThrow(() -> new ResourceNotFoundException("Compte not found"));
        compte.setSolde(compte.getSolde() + montant);
        compteBancaireRepository.save(compte);

        Operation operation = new Operation("DEPOT", montant, compte);
        operationRepository.save(operation);
    }

    public void retrait(Long compteId, Double montant) {
        CompteBancaire compte = compteBancaireRepository.findById(compteId)
                .orElseThrow(() -> new ResourceNotFoundException("Compte not found"));
        if (compte.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant");
        }
        compte.setSolde(compte.getSolde() - montant);
        compteBancaireRepository.save(compte);

        Operation operation = new Operation("RETRAIT", montant, compte);
        operationRepository.save(operation);
    }
}
