package pizzerialuccini;

import pizzerialuccini.builder.CustomPizzaBuilder;
import pizzerialuccini.decorator.*;
import pizzerialuccini.model.*;

import java.util.*;
import pizzerialuccini.builder.PizzaBuilder;

public class PizzeriaLuccini
{
    private static Scanner scanner = new Scanner(System.in);

    // Datos temporales
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pizzero> pizzeros = new ArrayList<>();
    private static List<PizzaComponent> pizzas = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        
        // Cargar datos iniciales
        poblarDatosIniciales();
        poblarPizzasPredeterminadas();
        
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS DE PIZZAS ARTESANALES ===");
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Ingresar Pizzero");
            System.out.println("3. Crear Pizza");
            System.out.println("4. Registrar Pedido");
            System.out.println("5. Mostrar Pedidos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> ingresarCliente();
                case 2 -> ingresarPizzero();
                case 3 -> crearPizza();
                case 4 -> registrarPedido();
                case 5 -> mostrarPedidos();
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }
    
    private static void poblarDatosIniciales() {
        // Poblar clientes
        clientes.add(new Cliente("11111111-1", "Juan Pérez", (byte) 30, "juan@mail.com"));
        clientes.add(new Cliente("22222222-2", "María González", (byte) 70, "maria@mail.com"));
        clientes.add(new Cliente("33333333-3", "Pedro Ramírez", (byte) 45, "pedro@mail.com"));

        // Poblar pizzeros
        pizzeros.add(new Pizzero("44444444-4", 1, "Luigi", "2019-05-10", "Pizzas clásicas"));
        pizzeros.add(new Pizzero("55555555-5", 2, "Mario", "2021-02-15", "Pizzas gourmet"));
        pizzeros.add(new Pizzero("66666666-6", 3, "Giovanni", "2022-09-20", "Pizzas vegetarianas"));

        System.out.println("Datos iniciales cargados (3 clientes y 3 pizzeros).");
    }
    
    private static void poblarPizzasPredeterminadas() {
        // Pizza Margarita
        PizzaComponent margarita = new CustomPizzaBuilder()
                .setNombre("Margarita")
                .setTamaño("Mediana")
                .setMasa("Tradicional")
                .addIngrediente("Salsa de tomate")
                .addIngrediente("Queso mozzarella")
                .addIngrediente("Albahaca")
                .calcularPrecio()
                .build();

        // Pizza Pepperoni
        PizzaComponent pepperoni = new CustomPizzaBuilder()
                .setNombre("Pepperoni")
                .setTamaño("Familiar")
                .setMasa("Napolitana")
                .addIngrediente("Salsa de tomate")
                .addIngrediente("Queso mozzarella")
                .addIngrediente("Pepperoni")
                .calcularPrecio()
                .build();

        // Pizza Cuatro Quesos
        PizzaComponent cuatroQuesos = new CustomPizzaBuilder()
                .setNombre("Cuatro Quesos")
                .setTamaño("Mediana")
                .setMasa("Integral")
                .addIngrediente("Queso mozzarella")
                .addIngrediente("Queso gorgonzola")
                .addIngrediente("Queso parmesano")
                .addIngrediente("Queso gouda")
                .calcularPrecio()
                .build();

        pizzas.add(margarita);
        pizzas.add(pepperoni);
        pizzas.add(cuatroQuesos);

        System.out.println("Pizzas predeterminadas cargadas (Margarita, Pepperoni, Cuatro Quesos).");
    }

    // --- OPCIONES DEL MENÚ ---

    private static void ingresarCliente() {
        System.out.print("RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        byte edad = scanner.nextByte();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        clientes.add(new Cliente(rut, nombre, edad, email));
        System.out.println("Cliente registrado con éxito.");
    }

    private static void ingresarPizzero() {
        System.out.print("RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Nro Pizzero: ");
        int nro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha Ingreso (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        pizzeros.add(new Pizzero(rut, nro, nombre, fecha, especialidad));
        System.out.println("Pizzero registrado con éxito.");
    }

    private static void crearPizza() {
        System.out.print("Nombre de la pizza: ");
        String nombre = scanner.nextLine();

        System.out.print("Tamaño (Personal/Mediana/Familiar): ");
        String tamaño = scanner.nextLine();

        System.out.print("Masa (Tradicional/Integral/Napolitana): ");
        String masa = scanner.nextLine();

        PizzaBuilder builder = new CustomPizzaBuilder()
                .setNombre(nombre)
                .setTamaño(tamaño)
                .setMasa(masa);

        // Ingredientes base
        while (true) {
            System.out.print("Ingrediente (o vacío para terminar): ");
            String ing = scanner.nextLine();
            if (ing.isEmpty()) {
                break;
            }
            builder.addIngrediente(ing);
        }

        // Nota: build() devuelve BasePizza (que implementa PizzaComponent)
        PizzaComponent pizza = builder.calcularPrecio().build();

        // Aplicar decoradores sin castings
        System.out.print("¿Agregar Queso Extra? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            pizza = new QuesoExtra(pizza);
        }
        System.out.print("¿Agregar Pepperoni Extra? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            pizza = new PepperoniExtra(pizza);
        }
        System.out.print("¿Agregar Champiñones Extra? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            pizza = new ChampinonesExtra(pizza);
        }
        System.out.print("¿Agregar Borde Relleno? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            pizza = new BordeRelleno(pizza);
        }

        pizzas.add(pizza); // pizzas debe ser List<PizzaComponent>
        System.out.println("Pizza creada: " + pizza.getDescripcion() + " → $" + pizza.getPrecio());
    }

    private static void registrarPedido() {
        if (clientes.isEmpty() || pizzeros.isEmpty() || pizzas.isEmpty()) {
            System.out.println("Debe registrar al menos un cliente, un pizzero y una pizza antes.");
            return;
        }

        System.out.println("Seleccione cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
        }
        int cliIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Seleccione pizzero:");
        for (int i = 0; i < pizzeros.size(); i++) {
            System.out.println((i + 1) + ". " + pizzeros.get(i).getNombre());
        }
        int pizIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Pedido pedido = new Pedido(clientes.get(cliIndex), pizzeros.get(pizIndex));

        System.out.println("Seleccione pizzas (ingrese índice, 0 para terminar):");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + ". " + pizzas.get(i).getDescripcion() + " → $" + pizzas.get(i).getPrecio());
        }

        int idx;
        do {
            idx = scanner.nextInt();
            scanner.nextLine();
            if (idx > 0 && idx <= pizzas.size()) {
                pedido.agregarPizza(pizzas.get(idx - 1));
                System.out.println("Pizza añadida, agrega otra pizza o ingresa 0 para continuar...");
            }
        } while (idx != 0);

        pedidos.add(pedido);
        System.out.println("Pedido registrado con éxito.");
    }

    private static void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
    
}
