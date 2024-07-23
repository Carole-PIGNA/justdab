package com.example.justdab.configuration;

import com.example.justdab.model.Client;
import com.example.justdab.model.CompteBancaire;
import com.example.justdab.model.Conseiller;
import com.example.justdab.repository.ClientRepository;
import com.example.justdab.repository.CompteBancaireRepository;
import com.example.justdab.repository.ConseillerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DBConfig {

   @Bean
    CommandLineRunner commandLineRunner (ClientRepository clientRepository, ConseillerRepository conseillerRepository, CompteBancaireRepository compteBancaireRepository ){
        return args ->{
            Conseiller conseiller1 = new Conseiller(

                    "Charles Dupuis", "charles.dupuis@example.com"
            );
            Conseiller conseiller2 = new Conseiller(

                    "Diane Lefevre", "diane.lefevre@example.com"
            );
            conseillerRepository.saveAll(
                    List.of(conseiller1,conseiller2)

            );
           Client client1 = new Client(

                    "Alice Dupont", "alice.dupont@example.com", conseiller1
            );
            Client client2 = new Client(

                    "Marie Dupont", "alice.dupont2@example.com", conseiller2
            );
            clientRepository.saveAll(
                    List.of(client1,client2)

            );


            CompteBancaire compte1 = new CompteBancaire(

                    10.000, 20L
            );
            CompteBancaire compte2 = new CompteBancaire(

                    300.0, 30L
            );
            compteBancaireRepository.saveAll(
                    List.of(compte1,compte2)

            );



        };
    }


}
