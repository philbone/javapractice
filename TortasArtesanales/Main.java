import java.util.*;

public abstract class Main {
    public static void main(String[] args) {       
        
        Scanner scanner = new Scanner(System.in);
        
        // Inputs del Cliente
        System.out.print("Rut Cliente: ");
        String cliente_rut = scanner.nextLine();
        System.out.print("Nombre Cliente: ");
        String cliente_nombre = scanner.nextLine();
        System.out.print("Edad Cliente: ");
        int cliente_edad = Integer.parseInt(scanner.nextLine()); // Convertir a int
        System.out.print("Email Cliente: ");        
        String cliente_email = scanner.nextLine();

        // Inputs del Pastelero
        System.out.print("Rut Pastelero: ");
        String pastelero_rut = scanner.nextLine();        
        System.out.print("N° Pastelero: ");
        int pastelero_numero = Integer.parseInt(scanner.nextLine()); // Convertir a int                
        System.out.print("Nombre Pastelero: ");
        String pastelero_nombre = scanner.nextLine();
        System.out.print("Fecha Ingreso Pastelero: ");
        String pastelero_fecha = scanner.nextLine();
        System.out.print("Especialidad Pastelero: ");
        String pastelero_especialidad = scanner.nextLine();
        
        // Inputs de la Torta
        System.out.print("Código Torta: ");
        int torta_codigo = Integer.parseInt(scanner.nextLine()); // Convertir a int
        System.out.print("Nombre Torta: ");
        String torta_nombre = scanner.nextLine();    
        
        // Inputs para el tamaño
        System.out.println("=== ELIGE EL TAMAÑO DE TU TORTA ===");
        System.out.println("1. Ocho porciones");
        System.out.println("2. Doce porciones");
        System.out.println("3. Veinte porciones");
        System.out.print("Seleccione una opción (1-3): ");        
        int torta_tamano_opcion = Integer.parseInt(scanner.nextLine()); // Convertir a int        
        String torta_tamano;        
        switch (torta_tamano_opcion) {
            case 1:
                torta_tamano = "8 porciones";
                break;
            case 2:
                torta_tamano = "12 porciones";
                break;
            case 3:
                torta_tamano = "20 porciones";
                break;
            default:
                torta_tamano = "Opción inválida - Porciones no definidas";
                break;
        }
        System.out.print("Tamaño Elegido: " + torta_tamano);
        System.out.println("");
        
        // Inputs para el sabor
        System.out.println("=== ELIGE EL SABOR DE TU TORTA ===");
        System.out.println("1. Vainilla");
        System.out.println("2. Chocolate");
        System.out.println("3. Tres Leches");
        System.out.println("4. Pistacho");
        System.out.print("Seleccione una opción (1-4): "); 
        int torta_sabor_opcion = Integer.parseInt(scanner.nextLine()); // Convertir a int 
        String torta_sabor;        
        switch (torta_sabor_opcion) {
            case 1:
                torta_sabor = "Vainilla";
                break;
            case 2:
                torta_sabor = "Chocolate";
                break;
            case 3:
                torta_sabor = "Tres Leches";
                break;
            case 4:
                torta_sabor = "Pistacho";
                break;
            default:
                torta_sabor = "Opción inválida - Sabor no definido";
                break;
        }
        System.out.print("Sabor Elegido: " + torta_sabor);
        System.out.println("");
        
        // Inputs para la decoración
        System.out.println("=== ELIGE LA DECORACIÓN DE TU TORTA ===");
        System.out.println("1. Simple");
        System.out.println("2. Personalizada");
        System.out.println("3. Temática");
        System.out.print("Seleccione una opción (1-3): "); 
        int torta_decoracion_opcion = Integer.parseInt(scanner.nextLine()); // Convertir a int 
        String torta_decoracion;
        switch (torta_decoracion_opcion) {
            case 1:
                torta_decoracion = "Simple";
                break;
            case 2:
                torta_decoracion = "Personalizada";
                break;
            case 3:
                torta_decoracion = "Temática";
                break;
            default:
                torta_decoracion = "Opción inválida - Decoración no definida";
                break;
        }
        System.out.print("Decoración Elegida: " + torta_decoracion);  
        System.out.println("");
        
        System.out.print("Cantidad de Tortas: ");
        int torta_cantidad = Integer.parseInt(scanner.nextLine()); // Convertir a int 
        
        scanner.close();
        
        // Se instancian los objetos necesarios para la actividad
        Cliente cliente = new Cliente(cliente_rut, cliente_nombre, cliente_edad, cliente_email);
        Pastelero pastelero = new Pastelero(pastelero_rut, pastelero_numero, pastelero_nombre, pastelero_fecha, pastelero_especialidad);
        Torta torta = TortaFactory.crearTorta(torta_codigo, torta_nombre, torta_tamano, torta_sabor, torta_decoracion);
        
        // Agregamos los descuentos disponibles a la lista de descuentos
        List<DescuentoStrategy> descuentos = Arrays.asList(new DescuentoEdad(), new DescuentoMonto());
        
        // Armamos la venta con el cliente, la torta, el pastelero, la cantidad, la fecha y la lista de descuentos
        Venta venta = new Venta(cliente, torta, pastelero, torta_cantidad, new Date(2025,8,5), descuentos);
        
        // la venta se auto-comprueba si es válida
        if (venta.esValida()) {
            System.out.println("Fecha Venta: " + venta.getFechaVenta());
            
            // Imprime el total bruto(precio unitario de la torta + tamaño + sabor + decoración)
            System.out.println("Total Bruto: " + venta.calcularTotalBruto());            
            // Imprime el total neto(total bruto - descuentos)
            System.out.println("Total Neto: " + venta.calcularTotalNeto());
        } else {
            System.out.println("❌ Venta inválida.");
        }
    }
}
