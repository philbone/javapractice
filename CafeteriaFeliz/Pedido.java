import java.util.List;
import java.util.ArrayList;

public class Pedido
{
    private List<Bebida> bebidas;
    
    public Pedido(){
        this.bebidas = new ArrayList<>();
    }
    
    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }
    
    public double calcularTotal() {
        double total = 0;
        for (Bebida bebida : bebidas) {
            total += bebida.getPrecio();
        }
        return total;
    }
    
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