package giovannighirardelli.u5_w1_d5.entities;


import com.github.javafaker.Faker;
import giovannighirardelli.u5_w1_d5.enums.Tipo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {
    Faker faker= new Faker(Locale.ITALY);

    @Bean
    public Edificio edificio1(){
        return new Edificio("Palazzo dei congressi", "Via Del Corso 9", "Roma");
    }

    @Bean
    public Edificio edificio2(){
        return new Edificio("Palazzo Sforza", "Piazza del duomo 3", "Milano");
    }
    @Bean
    public Edificio edificio3(){
        return  new Edificio("Vesuviano", "Via del Plebiscito 32", "Napoli");
    }
    @Bean
    public Edificio edificio4(){
        return new Edificio("Colosseo quadrato", "Viale Marco Polo 256", "Roma");
    }
    @Bean
    public Edificio edificio5(){
        return new Edificio("Eliseo", "Via Roma 1", "Firenze");
    }

    @Bean
    public Postazione postazione1(){
        return new Postazione("Piccolo spazio per lavorare in serenità", Tipo.PRIVATO, 1, edificio1());
    }

    @Bean
    public Postazione postazione2(){
        return new Postazione("Spazio di lavoro comune, comodo per il networking", Tipo.OPENSPACE, 12, edificio3());
    }

    @Bean
    public Postazione postazione3(){
        return new Postazione("Elegante sala dotata di tutti i comfort per le aziende", Tipo.SALA_RIUONIONI, 89, edificio4() );
    }
    @Bean
    public Postazione postazione4(){
        return new Postazione("Openspace curato con postazioni singole per lavorare in pace", Tipo.OPENSPACE, 9, edificio2());
    }
    @Bean Postazione postazione5(){
        return new Postazione("Piccolo ufficio privato per lavoro in solitaria", Tipo.PRIVATO, 1, edificio5());
    }

    @Bean Utente utente(){
        return new Utente(faker.pokemon().name(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
    }
}
