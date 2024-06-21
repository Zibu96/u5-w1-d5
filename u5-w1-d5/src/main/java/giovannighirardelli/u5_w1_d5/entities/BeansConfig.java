package giovannighirardelli.u5_w1_d5.entities;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

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

}
