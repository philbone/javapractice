import java.util.Map;

public class TortaFactory
{
    // Tabla de precio base por tamaño
    private static final Map<String, Integer> preciosBase = Map.of(
            "8 porciones", 12000,
            "12 porciones", 18000,
            "20 porciones", 30000
    );

    // Recargos por sabor
    private static final Map<String, Double> recargosSabor = Map.of(
            "Vainilla", 0.0,
            "Chocolate", 0.10,
            "Tres Leches", 0.15,
            "Pistacho", 0.20
    );
    
    // Recargos por decoración
    private static final Map<String, Integer> recargosDecoracion = Map.of(
            "Simple", 0,
            "Personalizada", 5000,
            "Temática", 10000
    );

    public static Torta crearTorta(int codigo, String nombre, String tamano, String sabor, String decoracion) {
        int base = preciosBase.getOrDefault(tamano, 0);
        double recargoSabor = recargosSabor.getOrDefault(sabor, 0.0);
        int recargoDecoracion = recargosDecoracion.getOrDefault(decoracion, 0);

        double precioUnitario = base * (1 + recargoSabor) + recargoDecoracion;

        return new Torta(codigo, nombre, tamano, sabor, decoracion, precioUnitario);
    }
}