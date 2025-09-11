import java.util.*;

public abstract class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente("1456764-9", "Juan Pérez", 80, "juan@mail.com");
        Pastelero pastelero = new Pastelero("24654844-7", 1, "Ana López", "20200101", "decoración temática");
        Torta torta = TortaFactory.crearTorta(1, "Torta Cumpleaños", "12 porciones", "Chocolate", "Personalizada");

        List<DescuentoStrategy> descuentos = Arrays.asList(new DescuentoEdad(), new DescuentoMonto());

        Venta venta = new Venta(cliente, torta, pastelero, 1, new Date(2025,8,5), descuentos);

        if (venta.esValida()) {
            System.out.println("Fecha Venta: " + venta.getFechaVenta());
            System.out.println("Total Bruto: " + venta.calcularTotalBruto());
            System.out.println("Total Neto: " + venta.calcularTotalNeto());
        } else {
            System.out.println("❌ Venta inválida.");
        }
    }
}
