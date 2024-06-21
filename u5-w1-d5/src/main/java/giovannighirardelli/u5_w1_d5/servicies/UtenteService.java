package giovannighirardelli.u5_w1_d5.servicies;

import giovannighirardelli.u5_w1_d5.entities.Edificio;
import giovannighirardelli.u5_w1_d5.entities.Postazione;
import giovannighirardelli.u5_w1_d5.entities.Utente;
import giovannighirardelli.u5_w1_d5.exceptions.ItemNotFoundException;
import giovannighirardelli.u5_w1_d5.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;


    public void saveUtente(Utente newUtente){

//        CONTROLLO SULL'USERNAME
        if(utenteRepository.existsByUsername(newUtente.getUsername())) {
            throw new RuntimeException("Lo username ' " + newUtente.getUsername() + " è già presente nel db!");
        }
//        CONTROLLO SUL NOME E COGNOME
        if(utenteRepository.existsByNomeAndCognome(newUtente.getNome(), newUtente.getCognome())) {
            throw new RuntimeException("L'utente " + newUtente.getNome() + " " +newUtente.getCognome() + " è già presente nel db!");
        }
//         CONTROLLO SULL' EMAIL
        if(utenteRepository.existsByEmail(newUtente.getEmail())) {
            throw new RuntimeException("La mail " + newUtente.getEmail() + " è già presente nel db!");
        }

        utenteRepository.save(newUtente);
        System.out.println("L'utente " + newUtente.getNome() + " è stato salvato nel db");



    }
    public Utente findById(long utenteId){

        return utenteRepository.findById(utenteId).orElseThrow(() -> new ItemNotFoundException(utenteId));

    }

}
