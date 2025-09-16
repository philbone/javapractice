package pizzerialuccini;

import pizzerialuccini.builder.CustomPizzaBuilder;
import pizzerialuccini.decorator.*;
import pizzerialuccini.model.*;

public class PizzeriaLuccini {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("12345678-9", "Juan Pérez", (byte)70, "juan@mail.com");
        Pizzero pizzero = new Pizzero("98765432-1", 1, "Luigi", "2020-01-01", "Pizzas clásicas");

        // Pizza Margarita con extras
        BasePizza margarita = new CustomPizzaBuilder()
            .setNombre("Margarita")
            .setTamaño("Mediana")
            .setMasa("Tradicional")
            .addIngrediente("Salsa de tomate")
            .addIngrediente("Queso mozzarella")
            .addIngrediente("Albahaca")
            .calcularPrecio()
            .build();
        PizzaComponent margaritaConExtras = new QuesoExtra(new BordeRelleno(margarita));

        // Pizza Pepperoni personalizada
        BasePizza pepperoni = new CustomPizzaBuilder()
            .setNombre("Pepperoni")
            .setTamaño("Familiar")
            .setMasa("Napolitana")
            .addIngrediente("Salsa de tomate")
            .addIngrediente("Queso mozzarella")
            .addIngrediente("Pepperoni")
            .calcularPrecio()
            .build();

        // Crear el pedido
        Pedido pedido = new Pedido(cliente, pizzero);
        pedido.agregarPizza(margaritaConExtras);
        pedido.agregarPizza(pepperoni);

        // Mostrar pedido
        System.out.println(pedido);
    }
}