package pizzerialuccini.builder;

import pizzerialuccini.decorator.BasePizza;

public class CustomPizzaBuilder implements PizzaBuilder
{
    private BasePizza pizza = new BasePizza();

    @Override
    public PizzaBuilder setNombre(String nombre) {
        pizza.setNombre(nombre);
        return this;
    }

    @Override
    public PizzaBuilder setTamaño(String tamaño) {
        pizza.setTamaño(tamaño);
        return this;
    }

    @Override
    public PizzaBuilder setMasa(String masa) {
        pizza.setMasa(masa);
        return this;
    }

    @Override
    public PizzaBuilder addIngrediente(String ingrediente) {
        pizza.addIngrediente(ingrediente);
        return this;
    }

    @Override
    public PizzaBuilder calcularPrecio() {
        double base = switch (pizza.getTamaño()) {
            case "Personal" -> 6000;
            case "Mediana" -> 10000;
            case "Familiar" -> 15000;
            default -> 0;
        };

        double recargoMasa = switch (pizza.getMasa()) {
            case "Integral" -> 1.10;
            case "Napolitana" -> 1.20;
            default -> 1.0;
        };

        double precio = base * recargoMasa;
        pizza.setPrecio(precio);
        return this;
    }

    @Override
    public BasePizza build() {
        return pizza;
    }
}