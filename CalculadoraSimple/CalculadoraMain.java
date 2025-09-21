import terminalmenu.Menu;
import terminalmenu.MenuBuilder;
import calculadorasimple.comandos.*;

public class CalculadoraMain
{
    public static void main(String[] args) {
        Menu menu = new MenuBuilder("=== CALCULADORA SIMPLE ===", false)
            .opcion("Resolver expresión", new ComandoResolverExpresion())
            .submenu("Ayuda", new MenuBuilder("MANUAL DE USO", true)
                .opcion("Uso Básico", () -> System.out.println("\nMostrando manual..."))
                .opcion("Créditos", () -> System.out.println("\nMostrando ASCII") ))
            .opcion("Salir", new ComandoSalir())
            .build();

        menu.mostrar();
    }   
    
}