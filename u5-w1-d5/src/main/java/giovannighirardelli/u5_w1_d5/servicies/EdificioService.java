package giovannighirardelli.u5_w1_d5.servicies;

import giovannighirardelli.u5_w1_d5.entities.Edificio;
import giovannighirardelli.u5_w1_d5.exceptions.ItemNotFoundException;
import giovannighirardelli.u5_w1_d5.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void saveEdificio(Edificio newEdificio){

        if(edificioRepository.existsByNome(newEdificio.getNome())) {
            throw new RuntimeException("L'edificio " + newEdificio.getNome() + " è già presente nel db!");
        }

        edificioRepository.save(newEdificio);
        System.out.println(newEdificio.getNome() + " Salvato correttamente nel db");
    }

    public Edificio findById(long edificioId){

        return edificioRepository.findById(edificioId).orElseThrow(() -> new ItemNotFoundException(edificioId));

    }

    public List<Edificio> findByCity(String city){
        return edificioRepository.findByCity(city);
    }
}
