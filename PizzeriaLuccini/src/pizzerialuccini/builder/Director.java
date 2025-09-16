package pizzerialuccini.builder;

import pizzerialuccini.decorator.BasePizza;

public class Director
{
    public BasePizza construir(PizzaBuilder builder) {
        return builder
            .setTamaño("Mediana")
            .setMasa("Tradicional")
            .addIngrediente("Salsa de tomate")
            .addIngrediente("Queso mozzarella")
            .calcularPrecio()
            .build();
    }

    public BasePizza construirMargarita(PizzaBuilder builder) {
        return builder
            .setNombre("Margarita")
            .setTamaño("Mediana")
            .setMasa("Tradicional")
            .addIngrediente("Salsa de tomate")
            .addIngrediente("Queso mozzarella")
            .addIngrediente("Albahaca")
            .calcularPrecio()
            .build();
    }

    public BasePizza construirPepperoni(PizzaBuilder builder) {
        return builder
            .setNombre("Pepperoni")
            .setTamaño("Mediana")
            .setMasa("Tradicional")
            .addIngrediente("Salsa de tomate")
            .addIngrediente("Queso mozzarella")
            .addIngrediente("Pepperoni")
            .calcularPrecio()
            .build();
    }

    public BasePizza construirCuatroQuesos(PizzaBuilder builder) {
        return builder
            .setNombre("Cuatro Quesos")
            .setTamaño("Mediana")
            .setMasa("Tradicional")
            .addIngrediente("Queso mozzarella")
            .addIngrediente("Queso gorgonzola")
            .addIngrediente("Queso parmesano")
            .addIngrediente("Queso gouda")
            .calcularPrecio()
            .build();
    }
}
