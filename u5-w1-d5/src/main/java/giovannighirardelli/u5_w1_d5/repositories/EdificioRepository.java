package giovannighirardelli.u5_w1_d5.repositories;

import giovannighirardelli.u5_w1_d5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    boolean existsByNome(String nome);

    List<Edificio> findByCity(String city);
}
