// Descuento por monto
public class DescuentoMonto implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double monto, Cliente cliente) {
        if (monto >= 120000) {
            return monto * 0.80; // -20%
        } else if (monto > 50000) {
            return monto * 0.90; // -10%
        }
        return monto;
    }
}