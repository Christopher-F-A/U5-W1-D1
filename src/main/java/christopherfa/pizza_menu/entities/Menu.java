package christopherfa.pizza_menu.entities;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {
    private List<Pizza> pizzaList = new ArrayList<>();
    private List<Topping> toppingList = new ArrayList<>();
    private List<Drink> drinkList = new ArrayList<>();
}