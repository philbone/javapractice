import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public abstract class Main
{
    private static List<BebidaBase> bebidasBase;
    private static Map<Integer, IngredienteExtra> ingredientes;
    private static Pedido pedidoActual;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        inicializarDatos();
        scanner = new Scanner(System.in);
        pedidoActual = new Pedido();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    mostrarBebidasBase();
                    break;
                case 2:
                    personalizarBebida();
                    break;
                case 3:
                    pedidoActual.mostrarPedido();
                    break;
                case 4:
                    finalizarPedido();
                    break;
                case 5:
                    System.out.println("¡Gracias por visitar El Grano Feliz!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
    
    private static void inicializarDatos() {
        bebidasBase = Arrays.asList(
            new BebidaBase("Café Negro", 1500, new PreparacionCafe()),
            new BebidaBase("Té", 1200, new PreparacionTe()),
            new BebidaBase("Capuccino", 2000, new PreparacionCapuccino()),
            new BebidaBase("Chocolate Caliente", 1800, new PreparacionChocolate())
        );
        ingredientes = new HashMap<>();
        ingredientes.put(1, new LecheExtra(null));
        ingredientes.put(2, new ChocolateExtra(null));
        ingredientes.put(3, new CremaExtra(null));
        ingredientes.put(4, new LecheAlmendrasExtra(null));
    }
    
    private static void mostrarMenu() {
        System.out.println("\n--- CAFETERÍA EL GRANO FELIZ ---");
        System.out.println("1. Mostrar Bebidas Base");
        System.out.println("2. Personalizar una Bebida y Agregar al Pedido");
        System.out.println("3. Mostrar Pedido Actual");
        System.out.println("4. Finalizar Pedido (Checkout)");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static void mostrarBebidasBase() {
        System.out.println("\n--- BEBIDAS BASE ---");
        for (int i = 0; i < bebidasBase.size(); i++) {
            BebidaBase bebida = bebidasBase.get(i);
            System.out.println((i + 1) + ". " + bebida.getNombre() + " - $" + bebida.getPrecio());
        }
    }

    private static void personalizarBebida() {
        // Select base beverage
        mostrarBebidasBase();
        System.out.print("Seleccione una bebida base: ");
        int seleccionBase = scanner.nextInt() - 1;
        scanner.nextLine();

        if (seleccionBase < 0 || seleccionBase >= bebidasBase.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        Bebida bebidaPersonalizada = bebidasBase.get(seleccionBase);
        Set<Integer> ingredientesSeleccionados = new HashSet<>();
        int contadorIngredientes = 0;

        // Add ingredients
        while (contadorIngredientes < 3) {
            System.out.println("\nIngredientes disponibles:");
            System.out.println("1. Leche (+$500)");
            System.out.println("2. Chocolate (+$700)");
            System.out.println("3. Crema (+$600)");
            System.out.println("4. Leche de Almendras (+$800)");
            System.out.println("0. Finalizar personalización");
            System.out.println("Bebida actual: " + bebidaPersonalizada.getDescripcion());
            System.out.println("Precio actual: $" + bebidaPersonalizada.getPrecio());
            System.out.print("Seleccione un ingrediente (0 para terminar): ");

            int seleccionIngrediente = scanner.nextInt();
            scanner.nextLine();

            if (seleccionIngrediente == 0) {
                break;
            }

            if (seleccionIngrediente < 1 || seleccionIngrediente > 4) {
                System.out.println("Selección no válida.");
                continue;
            }

            if (ingredientesSeleccionados.contains(seleccionIngrediente)) {
                System.out.println("Este ingrediente ya fue agregado.");
                continue;
            }

            // Apply decorator pattern
            switch (seleccionIngrediente) {
                case 1:
                    bebidaPersonalizada = new LecheExtra(bebidaPersonalizada);
                    break;
                case 2:
                    bebidaPersonalizada = new ChocolateExtra(bebidaPersonalizada);
                    break;
                case 3:
                    bebidaPersonalizada = new CremaExtra(bebidaPersonalizada);
                    break;
                case 4:
                    bebidaPersonalizada = new LecheAlmendrasExtra(bebidaPersonalizada);
                    break;
            }

            ingredientesSeleccionados.add(seleccionIngrediente);
            contadorIngredientes++;

            System.out.println("Ingrediente agregado. Precio actual: $" + bebidaPersonalizada.getPrecio());
        }

        pedidoActual.agregarBebida(bebidaPersonalizada);
        System.out.println("Bebida personalizada agregada al pedido!");
    }

    private static void finalizarPedido() {
        System.out.println("\n=== CHECKOUT ===");
        pedidoActual.mostrarPedido();
        System.out.println("Gracias por su compra! :D");
        pedidoActual = new Pedido(); // Reset order
    }
}