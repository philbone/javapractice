package pizzerialuccini.model;

/**
 *
 * @author felipe
 */
import pizzerialuccini.decorator.PizzaComponent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido
{
    private Cliente cliente;
    private Pizzero pizzero;
    private List<PizzaComponent> pizzas = new ArrayList<>();
    private LocalDate fechaPedido;

    public Pedido(Cliente cliente, Pizzero pizzero) {
        this.cliente = cliente;
        this.pizzero = pizzero;
        this.fechaPedido = LocalDate.now();
    }

    public void agregarPizza(PizzaComponent pizza) {
        pizzas.add(pizza);
    }

    public double calcularTotalBruto() {
        return pizzas.stream()
                     .mapToDouble(PizzaComponent::getPrecio)
                     .sum();
    }

    public double calcularDescuentos() {
        double total = calcularTotalBruto();
        double descuentos = 0;

        // Regla 1: Descuento por edad > 65
        if (cliente.getEdad() > 65) {
            descuentos += total * 0.15;
            total -= total * 0.15;
        }

        // Regla 2: Descuento por monto
        if (total >= 80000) {
            descuentos += total * 0.20;
        } else if (total > 40000) {
            descuentos += total * 0.10;
        }

        return descuentos;
    }

    public double calcularTotalNeto() {
        return calcularTotalBruto() - calcularDescuentos();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Pedido ===\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("Pizzero: ").append(pizzero.getNombre()).append("\n");
        sb.append("Fecha: ").append(fechaPedido).append("\n");
        sb.append("Pizzas:\n");
        pizzas.forEach(p -> sb.append(" - ").append(p.getDescripcion())
                              .append(" ($").append(p.getPrecio()).append(")\n"));
        sb.append("Total Bruto: $").append(calcularTotalBruto()).append("\n");
        sb.append("Descuentos: $").append(calcularDescuentos()).append("\n");
        sb.append("Total Neto: $").append(calcularTotalNeto()).append("\n");
        return sb.toString();
    }
}
