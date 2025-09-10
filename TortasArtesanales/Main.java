import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente("1-9", "Juan Pérez", 70, "juan@mail.com");
        Pastelero pastelero = new Pastelero("2-7", 1, "Ana López", "20200101", "decoración temática");
        Torta torta = TortaFactory.crearTorta(1, "Torta Cumpleaños", "12 porciones", "Chocolate", "Personalizada");

        List<DescuentoStrategy> descuentos = Arrays.asList(new DescuentoEdad(), new DescuentoMonto());

        Venta venta = new Venta(cliente, torta, pastelero, 1, "20250910", descuentos);

        if (venta.esValida()) {
            System.out.println("Total Bruto: " + venta.calcularTotalBruto());
            System.out.println("Total Neto: " + venta.calcularTotalNeto());
        } else {
            System.out.println("❌ Venta inválida.");
        }
    }
}
