package ma.projet;

import ma.projet.entities.Client;
import ma.projet.entities.Voiture;
import ma.projet.feign.ClientService;
import ma.projet.rositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }

    /*@Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository) {
        return args -> {
            voitureRepository.save(new Voiture(Long.parseLong("1"), "Mat-00", "BMW", "GM-2007", Long.parseLong("1"), null));

        };
    }*/


    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
            return args -> {
                Client c1 = clientService.clientById(1L);
                Client c2 = clientService.clientById(2L);

                System.out.println("**************************");
                System.out.println("Id est :" + c2.getId());
                System.out.println("Nom est :" + c2.getNom());
                System.out.println("Age est :" + c2.getAge());
                System.out.println("**************************");
                System.out.println("**************************");
                System.out.println("Id est :" + c1.getId());
                System.out.println("Nom est :" + c1.getNom());
                System.out.println("Age est :" + c1.getAge());
                System.out.println("**************************");


                // Enregistrement des voitures avec les clients récupérés
                voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A333", "Corolla", 1L, c2));
                voitureRepository.save(new Voiture(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", 1L, c2));
                voitureRepository.save(new Voiture(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", 2L, c1));

            };
        }

}

