package pizzerialuccini.decorator;

/**
 *
 * @author felipe
 */
public abstract class ExtraDecorator implements PizzaComponent
{
    protected PizzaComponent pizza;

    public ExtraDecorator(PizzaComponent pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescripcion() {
        return pizza.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return pizza.getPrecio();
    }
}
