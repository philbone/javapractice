
public class TortaFactory
{
    private static final java.util.Map<String, Integer> preciosBase = java.util.Map.of(
            "8 porciones", 12000,
            "12 porciones", 18000,
            "20 porciones", 30000
    );

    private static final java.util.Map<String, Double> recargosSabor = java.util.Map.of(
            "Vainilla", 0.0,
            "Chocolate", 0.10,
            "Tres Leches", 0.15,
            "Pistacho", 0.20
    );

    private static final java.util.Map<String, Integer> recargosDecoracion = java.util.Map.of(
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