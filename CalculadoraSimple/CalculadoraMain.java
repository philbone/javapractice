import terminalmenu.Menu;
import terminalmenu.MenuBuilder;
import calculadorasimple.*;

import java.util.*;

public class CalculadoraMain {

    private static final Map<String, OperacionNOperandos> comandos = new HashMap<>();

    static {
        comandos.put("+", new ComandoSumar());
        comandos.put("-", new ComandoRestar());
        comandos.put("*", new ComandoMultiplicar());
        comandos.put("/", new ComandoDividir());
    }

    public static void main(String[] args) {
        Menu menu = new MenuBuilder("=== CALCULADORA SIMPLE ===", false)
            .opcion("Resolver expresión", () -> resolverExpresion())
            .opcion("Salir", () -> {
                System.out.println("\n¡Hasta pronto!");
                System.exit(0);
            })
            .build();

        menu.mostrar();
    }

    private static void resolverExpresion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa una expresión (ej: 1+2+3): ");
        String input = sc.nextLine().trim();
        
        // Detectar el operador (suponemos un solo tipo por expresión)
        String operador = detectarOperador(input);
        if (operador == null) {
            System.out.println("\nOperador no reconocido.");
            return;
        }

        // Separar operandos
        String[] partes = input.split("\\" + operador); // escapar operador
        List<Double> operandos = new ArrayList<>();
        try {
            for (String p : partes) {
                operandos.add(Double.parseDouble(p.trim()));
            }
        } catch (NumberFormatException e) {
            System.out.println("\nError: la expresión contiene valores no numéricos.");
            return;
        }

        // Ejecutar comando
        OperacionNOperandos comando = comandos.get(operador);
        try {
            double resultado = comando.operar(operandos);
            System.out.println("\n"+ input + " = " + resultado);
        } catch (Exception e) {
            System.out.println("\nError en la operación: " + e.getMessage());
        }
    }

    private static String detectarOperador(String input) {
        for (String op : comandos.keySet()) {
            if (input.contains(op)) {
                return op;
            }
        }
        return null;
    }
}
