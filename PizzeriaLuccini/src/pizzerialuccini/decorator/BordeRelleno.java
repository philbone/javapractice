package pizzerialuccini.decorator;

/**
 *
 * @author felipe
 */
public class BordeRelleno extends ExtraDecorator
{
    public BordeRelleno(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return pizza.getDescripcion() + " + Borde Relleno";
    }

    @Override
    public double getPrecio() {
        return pizza.getPrecio() + 2500;
    }
}
