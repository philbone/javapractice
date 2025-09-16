package pizzerialuccini.builder;

import pizzerialuccini.decorator.BasePizza;

public interface PizzaBuilder
{
    PizzaBuilder setNombre(String nombre);
    PizzaBuilder setTamaño(String tamaño);
    PizzaBuilder setMasa(String masa);
    PizzaBuilder addIngrediente(String ingrediente);
    PizzaBuilder calcularPrecio();
    BasePizza build();
}