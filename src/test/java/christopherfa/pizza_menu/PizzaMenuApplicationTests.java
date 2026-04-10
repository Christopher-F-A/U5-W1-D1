package christopherfa.pizza_menu;

import christopherfa.pizza_menu.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PizzaMenuApplicationTests {

    @Autowired
    private ApplicationContext ctx;

    // verifica esistenza del Bean Menu
    @Test
    void testMenuBeanExists() {
        Menu menu = ctx.getBean(Menu.class);
        assertNotNull(menu, "Il bean Menu deve essere caricato nel contesto Spring");
    }

    // verifica prezzo Margherita
    @Test
    void testMargheritaPrice() {
        Pizza margherita = ctx.getBean("pizzaMargherita", Pizza.class);
        assertEquals(4.99, margherita.getPrice(), "La margherita deve costare 4.99€");
    }

    //test parametrico
    @ParameterizedTest
    @ValueSource(strings = {"cheese", "ham", "salami"})
    void testToppingsPriceIsPositive(String beanName) {
        Topping t = ctx.getBean(beanName, Topping.class);
        assertTrue(t.getPrice() > 0, "Il prezzo del topping " + beanName + " deve essere maggiore di zero");
    }

    // totale ordine con coperto e pizza extra
    @Test
    void testCalcoloTotaleOrdine() {
        Tavolo t = new Tavolo(1, 4, StatoTavolo.LIBERO);
        Ordine o = new Ordine();
        o.setTavolo(t);
        o.setNumeroCoperti(2);
        o.setCostoCoperto(2.0);

        Pizza p = new Pizza("Test", 100, 5.0, null);
        o.getElementiOrdine().add(p);

        assertEquals(9.0, o.getTotale(), "Il totale (5€ pizza + 4€ coperti) deve essere 9.0€");
    }

    // calorie totali di una pizza composta
    @Test
    void testHawaiianPizzaCalories() {
        Pizza hawaiian = ctx.getBean("hawaiianPizza", Pizza.class);

        assertEquals(1024, hawaiian.getCalories());
    }
}