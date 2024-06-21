package giovannighirardelli.u5_w1_d5;


import giovannighirardelli.u5_w1_d5.entities.Edificio;
import giovannighirardelli.u5_w1_d5.entities.Postazione;
import giovannighirardelli.u5_w1_d5.entities.Prenotazione;
import giovannighirardelli.u5_w1_d5.entities.Utente;
import giovannighirardelli.u5_w1_d5.enums.Tipo;
import giovannighirardelli.u5_w1_d5.servicies.EdificioService;
import giovannighirardelli.u5_w1_d5.servicies.PostazioneService;
import giovannighirardelli.u5_w1_d5.servicies.PrenotazioneService;
import giovannighirardelli.u5_w1_d5.servicies.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GestionePrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U5W1D5Application.class);

//        CREAZIONE EDIFICI
//        Edificio edificio1 = (Edificio) context.getBean("edificio1");
//        edificioService.saveEdificio(edificio1);
        Edificio edificio2 = (Edificio) context.getBean("edificio2");
//        edificioService.saveEdificio(edificio2);
        Edificio edificio3 = (Edificio) context.getBean("edificio3");
//        edificioService.saveEdificio(edificio3);
        Edificio edificio4 = (Edificio) context.getBean("edificio4");
//        edificioService.saveEdificio(edificio4);
        Edificio edificio5 = (Edificio) context.getBean("edificio5");
//        edificioService.saveEdificio(edificio5);
       Edificio edificio1 =  edificioService.findById(106);

//       CREAZIONE POSTAZIONI
        Postazione postazione1 = new Postazione("Openspace curato con postazioni singole per lavorare in pace", Tipo.OPENSPACE, 9,   edificio1);
//        postazioneService.savePostazione(postazione1);

//  CREAZIONE PRENOTAZIONI
        Utente utente1 =context.getBean(Utente.class);
//        utenteService.saveUtente(utente1);
        Utente utente = utenteService.findById(452);

        Postazione postazione = postazioneService.findById(402);

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now().plusWeeks(2), postazione, utente);
//        prenotazioneService.savePrenotazione(prenotazione1);

//        QUERIES PER POSTAZIONE
        postazioneService.findByTipo("PRIVATO").forEach(System.out::println);
        postazioneService.findByTipoAndCity("PRIVATO", "Roma");

    }
}
