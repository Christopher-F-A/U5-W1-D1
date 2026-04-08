package christopherfa.pizza_menu.runners;

import christopherfa.pizza_menu.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class OrdineRunner implements CommandLineRunner {

    @Autowired
    private Menu menu;

    @Value("${pizzeria.costoCoperto}")
    private double costoCoperto;

    @Override
    public void run(String... args) throws Exception {
        log.info("--- Inizio Gestione Ordini ---");

        // crazione Tavolo
        Tavolo t1 = new Tavolo(1, 4, StatoTavolo.OCCUPATO);

        // creazione Ordine
        Ordine o1 = new Ordine();
        o1.setNumeroOrdine(1);
        o1.setTavolo(t1);
        o1.setStato(StatoOrdine.IN_CORSO);
        o1.setNumeroCoperti(2);
        o1.setOraAcquisizione(LocalDateTime.now());
        o1.setCostoCoperto(costoCoperto);

        // aggiunta elementi da menu
        o1.getElementiOrdine().add(menu.getPizzaList().get(0)); // margherita
        o1.getElementiOrdine().add(menu.getDrinkList().get(0)); // limonata

        // stampa
        log.info("Dettagli Ordine:");
        log.info("Tavolo: " + o1.getTavolo().getNumero());
        log.info("Stato: " + o1.getStato());
        log.info("Totale: " + o1.getTotale() + "€");
    }
}