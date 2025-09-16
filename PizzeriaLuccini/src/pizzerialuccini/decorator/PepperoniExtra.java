package pizzerialuccini.decorator;

/**
 *
 * @author felipe
 */
public class PepperoniExtra extends ExtraDecorator
{
    public PepperoniExtra(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return pizza.getDescripcion() + " + Pepperoni Extra";
    }

    @Override
    public double getPrecio() {
        return pizza.getPrecio() + 2000;
    }
}
