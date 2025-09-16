package pizzerialuccini;

import pizzerialuccini.builder.*;
import pizzerialuccini.decorator.BasePizza;

public class PizzeriaLuccini
{
    public static void main(String[] args) {
        
        Director director = new Director();

        // Receta clásica (Builder + Director)
        BasePizza margarita = director.construirMargarita(new CustomPizzaBuilder());
        System.out.println(margarita.getDescripcion() + " → $" + margarita.getPrecio());
        
        BasePizza cuatroQuesos = director.construirCuatroQuesos(new CustomPizzaBuilder());
        System.out.println(cuatroQuesos.getDescripcion() + " → $" + cuatroQuesos.getPrecio());

        // Receta personalizada (Builder fluido sin Director)
        BasePizza especial = new CustomPizzaBuilder()
            .setNombre("Especial de la Casa")
            .setTamaño("Familiar")
            .setMasa("Napolitana")
            .addIngrediente("Jamón")
            .addIngrediente("Aceitunas")
            .calcularPrecio()
            .build();
        System.out.println(especial.getDescripcion() + " → $" + especial.getPrecio());
        
        BasePizza chilena = new CustomPizzaBuilder()
                .setNombre("Chilena")
                .setTamaño("Familiar")
                .setMasa("De Empanada")
                .addIngrediente("Salsa de pebre")
                .addIngrediente("Cebolla")
                .addIngrediente("Carne Molida")
                .addIngrediente("Queso Chanco")
                .addIngrediente("Orégano")
                .calcularPrecio()
                .build();
        System.out.println(chilena.getDescripcion() + " → $" + chilena.getPrecio());
    }
}