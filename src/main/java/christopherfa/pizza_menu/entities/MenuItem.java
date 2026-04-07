package christopherfa.pizza_menu.entities;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class MenuItem {
    protected String name;
    protected Integer calories;
    protected Double price;
}
