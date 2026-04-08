package christopherfa.pizza_menu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tavolo {
    private int numero;
    private int maxCoperti;
    private StatoTavolo stato;
}