package com.example.justdab.controller;

import com.example.justdab.model.Client;
import com.example.justdab.service.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.justdab.exception.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/conseillers")
public class ConseillerController {

    @Autowired
    private ConseillerService conseillerService;

    @GetMapping("/{conseillerId}/clients")
    public ResponseEntity<List<Client>> getClientsByConseillerId(@PathVariable Long conseiller_id) {
        try {
            List<Client> clients = conseillerService.getClientsByConseillerId(conseiller_id);
            return ResponseEntity.ok(clients);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
