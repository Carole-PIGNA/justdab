package com.example.justdab.controller;

import com.example.justdab.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.justdab.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/comptes")
public class CompteBancaireController {

    @Autowired
    private CompteBancaireService compteBancaireService;

    @GetMapping("/{compteId}/solde")
    public ResponseEntity<Double> getSolde(@PathVariable Long compteId) {
        try {
            Double solde = compteBancaireService.consulterSolde(compteId);
            return ResponseEntity.ok(solde);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{compteId}/depot")
    public ResponseEntity<Void> depot(@PathVariable Long compteId, @RequestParam Double montant) {
        try {
            compteBancaireService.depot(compteId, montant);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{compteId}/retrait")
    public ResponseEntity<Void> retrait(@PathVariable Long compteId, @RequestParam Double montant) {
        try {
            compteBancaireService.retrait(compteId, montant);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
