package christopherfa.pizza_menu.configuration;

import christopherfa.pizza_menu.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class MenuConfig {

    // TOPPINGS
    @Bean
    public Topping tomato() { return new Topping("Tomato", 0, 0.0); }

    @Bean
    public Topping cheese() { return new Topping("Cheese", 92, 0.69); }

    @Bean
    public Topping ham() { return new Topping("Ham", 35, 0.99); }

    @Bean
    public Topping onions() { return new Topping("Onions", 22, 0.69); }

    @Bean
    public Topping pineapple() { return new Topping("Pineapple", 24, 0.79); }

    @Bean
    public Topping salami() { return new Topping("Salami", 86, 0.99); }

    // PIZZAS
    @Bean
    public Pizza pizzaMargherita() {
        return new Pizza("Pizza Margherita (tomato, cheese)", 1104, 4.99,
                List.of(tomato(), cheese()));
    }

    @Bean
    public Pizza hawaiianPizza() {
        return new Pizza("Hawaiian Pizza (tomato, cheese, ham, pineapple)", 1024, 6.49,
                List.of(tomato(), cheese(), ham(), pineapple()));
    }

    @Bean
    public Pizza salamiPizza() {
        return new Pizza("Salami Pizza (tomato, cheese, salami)", 1160, 5.99,
                List.of(tomato(), cheese(), salami()));
    }

    // DRINKS
    @Bean
    public Drink lemonade() { return new Drink("Lemonade (0.33l)", 128, 1.29); }

    @Bean
    public Drink water() { return new Drink("Water (0.5l)", 0, 1.29); }

    @Bean
    public Drink wine() { return new Drink("Wine (0.75l, 13%)", 607, 7.49); }

    // MENU BEAN
    @Bean
    public Menu menu() {
        Menu menu = new Menu();

        // Aggiunta pizze
        menu.getPizzaList().add(pizzaMargherita());
        menu.getPizzaList().add(hawaiianPizza());
        menu.getPizzaList().add(salamiPizza());

        // Aggiunta toppings
        menu.getToppingList().add(cheese());
        menu.getToppingList().add(ham());
        menu.getToppingList().add(onions());
        menu.getToppingList().add(pineapple());
        menu.getToppingList().add(salami());

        // Aggiunta drinks
        menu.getDrinkList().add(lemonade());
        menu.getDrinkList().add(water());
        menu.getDrinkList().add(wine());

        return menu;
    }
}