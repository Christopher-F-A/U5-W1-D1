package christopherfa.pizza_menu;

import christopherfa.pizza_menu.entities.*;
import org.junit.jupiter.api.Test;
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
    }}