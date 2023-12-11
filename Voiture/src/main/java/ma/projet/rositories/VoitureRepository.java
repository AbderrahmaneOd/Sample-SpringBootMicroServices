package ma.projet.rositories;

import feign.Param;
import ma.projet.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    @Query("SELECT v FROM Voiture v WHERE v.id_client = :clientId")
    List<Voiture> findByClientId(@Param("clientId") Long clientId);
}
