package pizzerialuccini;

import pizzerialuccini.builder.CustomPizzaBuilder;
import pizzerialuccini.decorator.*;

public class PizzeriaLuccini
{
    public static void main(String[] args) {
        pruebaBasica();
    }
    
    private static void pruebaBasica() {
        // 1. Construimos una pizza Margarita con el Builder
        BasePizza margarita = new CustomPizzaBuilder()
            .setNombre("Margarita")
            .setTamaño("Mediana")
            .setMasa("Tradicional")
            .addIngrediente("Salsa de tomate")
            .addIngrediente("Queso mozzarella")
            .addIngrediente("Albahaca")
            .calcularPrecio()
            .build();

        // 2. Decoramos con toppings extra
        PizzaComponent personalizada = new QuesoExtra(new BordeRelleno(new ChampinonesExtra(margarita)));

        // 3. Mostramos resultado
        System.out.println(personalizada.getDescripcion());
        System.out.println("Precio final: $" + personalizada.getPrecio());
    }
}