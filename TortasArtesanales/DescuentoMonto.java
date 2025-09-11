import java.util.Date;

// Descuento por monto
public class DescuentoMonto implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double monto, Cliente cliente, Date fecha) {
        if (monto >= 120000) {
            return monto * 0.80; // -20%
        } else if (monto > 50000) {
            return monto * 0.90; // -10%
        }
        return monto;
    }
}