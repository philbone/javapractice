package pizzerialuccini.decorator;

/**
 *
 * @author felipe
 */
public class ChampinonesExtra extends ExtraDecorator
{
    public ChampinonesExtra(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return pizza.getDescripcion() + " + Champiñones Extra";
    }

    @Override
    public double getPrecio() {
        return pizza.getPrecio() + 1800;
    }
}
