package christopherfa.pizza_menu;

import christopherfa.pizza_menu.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PizzaMenuApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PizzaMenuApplication.class, args);
		Menu menu = ctx.getBean(Menu.class);

		System.out.println("\n======= PIZZERIA MENU =======");

		// PIZZE
		System.out.println("\nPIZZAS Calories Price");
		menu.getPizzaList().forEach(p ->
				System.out.println(p.getName() + "\t" + p.getCalories() + "\t" + p.getPrice() + "€")
		);

		// TOPPINGS
		System.out.println("\nTOPPINGS Calories Price");
		menu.getToppingList().forEach(t ->
				System.out.println(t.getName() + "\t" + t.getCalories() + "\t" + t.getPrice() + "€")
		);

		// DRINKS
		System.out.println("\nDRINKS Calories Price");
		menu.getDrinkList().forEach(d ->
				System.out.println(d.getName() + "\t" + d.getCalories() + "\t" + d.getPrice() + "€")
		);

		System.out.println("\n=============================");
	}
}