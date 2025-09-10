import java.util.List;

public class Venta
{
    private Cliente cliente;
    private Torta torta;
    private Pastelero pastelero;
    private int cantidad;
    private String fechaVenta;
    private List<DescuentoStrategy> descuentos;

    public Venta(Cliente cliente, Torta torta, Pastelero pastelero, int cantidad, String fechaVenta, List<DescuentoStrategy> descuentos) {
        this.cliente = cliente;
        this.torta = torta;
        this.pastelero = pastelero;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.descuentos = descuentos;
    }

    public boolean esValida() {
        return cantidad > 0 && cliente.esValido() && pastelero.esValido() && torta.esValida();
    }

    public double calcularTotalBruto() {
        return cantidad * torta.getPrecioUnitario();
    }

    public double calcularTotalNeto() {
        double total = calcularTotalBruto();
        for (DescuentoStrategy d : descuentos) {
            total = d.aplicarDescuento(total, cliente);
        }
        return total;
    }
}