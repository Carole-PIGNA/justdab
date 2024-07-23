package com.example.justdab.service;

import com.example.justdab.model.Client;
import com.example.justdab.model.Conseiller;
import com.example.justdab.repository.ClientRepository;
import com.example.justdab.repository.ConseillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.justdab.exception.ResourceNotFoundException;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Conseiller consulterConseiller(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return client.getConseiller();
    }
}