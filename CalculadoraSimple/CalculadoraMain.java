import terminalmenu.Menu;
import terminalmenu.MenuBuilder;
import calculadorasimple.comandos.*;

public class CalculadoraMain
{
    public static void main(String[] args) {
        Menu menu = new MenuBuilder("=== CALCULADORA CON PARSER ===", false)
            .opcion("Resolver expresión", new ComandoResolverExpresion())
            .opcion("Salir", new ComandoSalir())
            .build();

        menu.mostrar();
    }
}