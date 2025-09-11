import java.util.Date;

// Descuento por edad
public class DescuentoEdad implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double monto, Cliente cliente, Date fecha) {
        if (cliente.getEdad() > 65) {
            return monto * 0.85; // -15%
        }
        return monto;
    }
}