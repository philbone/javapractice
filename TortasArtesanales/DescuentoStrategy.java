import java.util.Date;

public interface DescuentoStrategy {
    double aplicarDescuento(double monto, Cliente cliente, Date fecha);
}