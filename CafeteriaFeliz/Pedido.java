import java.util.List;
import java.util.ArrayList;
import ingredientedecorator.Bebida;

/**
 * Clase que representa un pedido con múltiples bebidas.
 * Gestiona la lista de bebidas y calcula el total del pedido.
 */
public class Pedido
{
    private List<Bebida> bebidas;
    
    /**
     * Constructor para crear un nuevo pedido vacío.
     */
    public Pedido(){
        this.bebidas = new ArrayList<>();
    }
    
    /**
     * Agrega una bebida al pedido actual.
     * @param bebida la bebida a agregar al pedido
     */
    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }
    
    /**
     * Calcula el precio total sumando todas las bebidas del pedido.
     * @return el total del pedido en CLP
     */
    public double calcularTotal() {
        double total = 0;
        for (Bebida bebida : bebidas) {
            total += bebida.getPrecio();
        }
        return total;
    }
    
    /**
     * Muestra por consola el detalle completo del pedido actual.
     * Incluye cada bebida con su descripción y precio, y el total final.
     */
    public void mostrarPedido() {
        System.out.println("\n--- PEDIDO ACTUAL ---");
        if (bebidas.isEmpty()) {
            System.out.println("No hay bebidas en el pedido.");
        } else {
            for (int i = 0; i < bebidas.size(); i++) {
                System.out.println((i + 1) + ". " + bebidas.get(i).getDescripcion() + " - $" + bebidas.get(i).getPrecio());
            }
            System.out.println("Total: $" + calcularTotal());
        }
        System.out.println("---------------------");
    }
}