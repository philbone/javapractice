package pizzerialuccini.decorator;

/**
 *
 * @author felipe
 */
public class QuesoExtra extends ExtraDecorator
{
    public QuesoExtra(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return pizza.getDescripcion() + " + Queso Extra";
    }

    @Override
    public double getPrecio() {
        return pizza.getPrecio() + 1500;
    }
}
