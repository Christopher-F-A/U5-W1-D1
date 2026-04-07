package christopherfa.pizza_menu.entities;

import lombok.*;

import java.util.List;


@Getter
@Setter
public class Pizza extends MenuItem {
    private List<Topping> toppingList;

    public Pizza(String name, Integer calories, Double price, List<Topping> toppings) {
        super(name, calories, price);
        this.toppingList = toppings;
    }
}