import java.util.Scanner;
import editor.Editor;
import editor.Historial;

/**
 * Programa principal con menú en consola.
 */
public class MainApp
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Editor editor = new Editor();
        Historial historial = new Historial();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Escribir texto");
            System.out.println("2. Guardar estado");
            System.out.println("3. Deshacer");
            System.out.println("4. Rehacer");
            System.out.println("5. Mostrar texto");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Escribe tu texto: ");
                    String nuevoTexto = scanner.nextLine();
                    editor.escribir(nuevoTexto);
                    break;
                case 2:
                    historial.guardar(editor.guardar());
                    System.out.println("[Estado guardado]");
                    break;
                case 3:
                    if (historial.puedeDeshacer()) {
                        editor.restaurar(historial.deshacer(editor.guardar()));
                        System.out.println("[Deshacer realizado]");
                    } else {
                        System.out.println("[No hay estados anteriores]");
                    }
                    break;
                case 4:
                    if (historial.puedeRehacer()) {
                        editor.restaurar(historial.rehacer(editor.guardar()));
                        System.out.println("[Rehacer realizado]");
                    } else {
                        System.out.println("[No hay estados para rehacer]");
                    }
                    break;
                case 5:
                    System.out.println("Texto actual: " + editor.getTexto());
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}