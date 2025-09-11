import java.util.*;

public abstract class Main
{
    private static Cliente cliente;
    private static Pastelero pastelero;
    private static Torta torta;
    private static Venta venta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        // Muestra el menú
        do {
            System.out.println("\n=== SISTEMA DE VENTAS DE TORTAS ARTESANALES ===");
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Ingresar Pastelero");
            System.out.println("3. Ingresar Torta");
            System.out.println("4. Registrar Venta");
            System.out.println("5. Mostrar Venta");
            System.out.println("6. Salir");
            System.out.print("SELECCIONA UNA OPCIÓN PARA CONTINUAR: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> cliente = ingresarCliente(scanner);
                case 2 -> pastelero = ingresarPastelero(scanner);
                case 3 -> torta = ingresarTorta(scanner);
                case 4 -> registrarVenta(scanner);
                case 5 -> mostrarVenta();
                case 6 -> salir();
                default -> System.out.println("XX LA OPCIÓN ELEGIDA ES INVÁLIDA XX");
            }
        } while (opcion != 6);

        scanner.close();
    }
    
    /* 
     * La responsabilidad de capturar los datos esta separara en distintos métodos de retorno(getters)
     * Estos métodos retornarán un objeto válidado de tipo Cliente, Pastelero o Torta según el caso.
     * De lo contrario retornarán null.
    */
    
   // Intenta la creacion de un Cliente, si es valido retorna un objeto de tipo Cliente
    private static Cliente ingresarCliente(Scanner sc) {
        System.out.print("Rut Cliente: ");
        String rut = sc.nextLine();
        System.out.print("Nombre Cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Edad Cliente: ");        
        byte edad = (byte)Integer.parseInt(sc.nextLine());// ojo: si el usuario introduce un número fuera del rango de byte produciría truncamiento
        System.out.print("Email Cliente: ");
        String email = sc.nextLine();
        Cliente c = new Cliente(rut, nombre, edad, email);
        if (!c.esValido()) {
            System.out.println("XX EL CLIENTE INGRESADO ES INVÁLIDO XX");
            return null;
        }
        System.out.println(">> SE HA REGISTRADO EL CLIENTE EXITOSAMENTE <<");
        return c;
    }
    
    // Intenta la creacion de un Pastelero, si es valido retorna un objeto de tipo Pastelero
    private static Pastelero ingresarPastelero(Scanner sc) {
        System.out.print("Rut Pastelero: ");
        String rut = sc.nextLine();
        System.out.print("N° Pastelero: ");
        int nro = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre Pastelero: ");
        String nombre = sc.nextLine();
        System.out.print("Fecha Ingreso (YYYYMMDD): ");
        String fechaIngreso = sc.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();
        Pastelero p = new Pastelero(rut, nro, nombre, fechaIngreso, especialidad);
        if (!p.esValido()) {
            System.out.println("XX EL PASTELERO INGRESADO ES INVÁLIDO XX");
            return null;
        }
        System.out.println(">> SE HA REGISTRADO EL PASTELERO EXITOSAMENTE <<");
        return p;
    }
    
    // Intenta la creacion de una Torta, si es valida retorna un objeto de tipo Torta
    private static Torta ingresarTorta(Scanner sc) {
        System.out.print("Código Torta: ");
        int codigo = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre Torta: ");
        String nombre = sc.nextLine();

        System.out.println("=== ELIGE EL TAMAÑO DE TU TORTA ===");
        System.out.println("1. 8 porciones");
        System.out.println("2. 12 porciones");
        System.out.println("3. 20 porciones");
        String tamano = switch (Integer.parseInt(sc.nextLine())) {
            case 1 -> "8 porciones";
            case 2 -> "12 porciones";
            case 3 -> "20 porciones";
            default -> "Inválido";
        };

        System.out.println("=== ELIGE EL SABOR DE TU TORTA ===");
        System.out.println("1. Vainilla");
        System.out.println("2. Chocolate");
        System.out.println("3. Tres Leches");
        System.out.println("4. Pistacho");
        String sabor = switch (Integer.parseInt(sc.nextLine())) {
            case 1 -> "Vainilla";
            case 2 -> "Chocolate";
            case 3 -> "Tres Leches";
            case 4 -> "Pistacho";
            default -> "Inválido";
        };

        System.out.println("=== ELIGE LA DECORACIÓN DE TU TORTA ===");
        System.out.println("1. Simple");
        System.out.println("2. Personalizada");
        System.out.println("3. Temática");
        String decoracion = switch (Integer.parseInt(sc.nextLine())) {
            case 1 -> "Simple";
            case 2 -> "Personalizada";
            case 3 -> "Temática";
            default -> "Inválido";
        };
        
        // Aquí usamos el Factory Method que implementamos para crear las tortas
        Torta t = TortaFactory.crearTorta(codigo, nombre, tamano, sabor, decoracion);
        
        // comprobamos si la torta es valida
        if (!t.esValida()) {
            System.out.println("XX LA TORTA INGRESADA NO ES VÁLIDA XX XX");
            return null;
        }
        System.out.println(">> TORTA REGISTRADA EXITOSAMENTE. PRECIO UNITARIO: $" + t.getPrecioUnitario() +" <<");
        return t;
    }
    
    // Para registrar la Venta debemos comprobar que Cliente, Pastelero y Torta sean distintos de null    
    private static void registrarVenta(Scanner sc) {
        if (cliente == null || pastelero == null || torta == null) {
            System.out.println(">> DEBES REGISTRAR CLIENTE, PASTELERO Y TORTA ANTES DE REGISTRAR UNA VENTA <<");
            return;
        }
        System.out.print("¿CUANTAS TORTAS COMO ESTA ORDENARÁ? ");
        int cantidad = Integer.parseInt(sc.nextLine());
        
        // Acá usamos el Strategy Pattern que implementamos para los descuentos
        List<DescuentoStrategy> descuentos = Arrays.asList(new DescuentoEdad(), new DescuentoMonto());
        venta = new Venta(cliente, torta, pastelero, cantidad, new Date(), descuentos);
        
        if (!venta.esValida()) {
            System.out.println("XX EL VENTA NO ES VÁLIDA XX");
            venta = null;
            return;
        }
        // Si la venta es válida avisamos al usuario
        System.out.println(">> VENTA REGISTRADA EXITOSAMENTE <<");
    }
    
    // Este método se encargará de imprimir la información del a venta por pantalla
    private static void mostrarVenta() {
        if (venta == null) {
            System.out.println(">> NO HAY VENTAS REGISTRADAS <<");
            return;
        }
        System.out.println("\n=== DETALLE DE LA VENTA ===");
        System.out.println("Fecha: " + venta.getFechaVenta());
        System.out.println("Cliente: " + venta.getCliente().getNombre());
        System.out.println("Pastelero: " + venta.getPastelero().getNombre());
        System.out.println("Torta: " + venta.getTorta().getNombre());
        System.out.println("Cantidad: " + venta.getCantidad());        
        System.out.println("Precio unitario: $" + venta.getTorta().getPrecioUnitario());
        System.out.println("Total Bruto: $" + venta.calcularTotalBruto());
        System.out.println("Total Neto: $" + venta.calcularTotalNeto());
    }
    
    // Este método se precupa de apagar el sistema
    private static void salir(){
        System.out.println("Saliendo del sistema...");
        System.out.println("Adiós...");
        System.exit(0);
    }
}
