package com.example.justdab.service;

import com.example.justdab.model.Client;
import com.example.justdab.model.Conseiller;
import com.example.justdab.repository.ConseillerRepository;
import com.example.justdab.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.justdab.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ConseillerService {

    @Autowired
    private ConseillerRepository conseillerRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientsByConseillerId(Long conseiller_id) {
        Optional<Conseiller> conseiller = conseillerRepository.findById(conseiller_id);
        if (conseiller.isPresent()) {
            return clientRepository.findByConseiller(conseiller.get());
        } else {
            throw new ResourceNotFoundException("Conseiller not found");
        }
    }
}
