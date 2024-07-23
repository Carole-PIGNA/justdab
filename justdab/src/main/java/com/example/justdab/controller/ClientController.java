package com.example.justdab.controller;

import com.example.justdab.model.Conseiller;
import com.example.justdab.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.justdab.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}/conseiller")
    public ResponseEntity<Conseiller> getConseiller(@PathVariable Long clientId) {
        try {
            Conseiller conseiller = clientService.consulterConseiller(clientId);
            return ResponseEntity.ok(conseiller);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
