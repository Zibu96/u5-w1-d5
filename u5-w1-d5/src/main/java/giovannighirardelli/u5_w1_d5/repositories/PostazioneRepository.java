package giovannighirardelli.u5_w1_d5.repositories;

import giovannighirardelli.u5_w1_d5.entities.Edificio;
import giovannighirardelli.u5_w1_d5.entities.Postazione;
import giovannighirardelli.u5_w1_d5.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {


boolean existsByDescrizione (String descrizione);



//List<Postazione> findByTipoAndEdificio(Tipo tipo, Edificio edificio);



    @Query("SELECT a FROM Postazione a WHERE a.tipo = UPPER(:tipo)")
    List<Postazione> findByTipo(String tipo);

    @Query("SELECT a FROM Postazione a WHERE a.tipo = UPPER(:tipo) AND a.edificio.city = :city")
    List<Postazione> findByTipoAndCity(String tipo, String city);
}
