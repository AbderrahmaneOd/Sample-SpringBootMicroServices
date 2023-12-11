package com.projet.client;

import com.projet.client.entities.Client;
import com.projet.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

    }

    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository){
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "SELIMANI", "Rabab", Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"), "RAMI", "Amal", Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"), "SAFI", "Samir", Float.parseFloat("22")));

        };
    }

}
