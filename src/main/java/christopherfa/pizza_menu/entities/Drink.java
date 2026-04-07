package christopherfa.pizza_menu.entities;

import lombok.NoArgsConstructor;

public class Drink extends MenuItem {
    public Drink(String name, Integer calories, Double price) {
        super(name, calories, price);
    }
}