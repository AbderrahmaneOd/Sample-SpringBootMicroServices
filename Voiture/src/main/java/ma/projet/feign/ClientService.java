package ma.projet.feign;


import ma.projet.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {

    @GetMapping("/client/{id}")
    public Client clientById(@PathVariable Long id);
}
