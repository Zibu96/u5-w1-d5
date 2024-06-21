package giovannighirardelli.u5_w1_d5.repositories;

import giovannighirardelli.u5_w1_d5.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

}
