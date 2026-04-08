package christopherfa.pizza_menu.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Ordine {
    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private List<MenuItem> elementiOrdine = new ArrayList<>();
    private Tavolo tavolo;
    private double costoCoperto;

    public double getTotale() {
        double totaleElementi = elementiOrdine.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
        return totaleElementi + (costoCoperto * numeroCoperti);
    }
}