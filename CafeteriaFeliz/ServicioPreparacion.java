import ingredientedecorator.Bebida;
import ingredientedecorator.IngredienteExtra;
import preparacionstrategy.PreparacionStrategy;

/**
 * Servicio dedicado a la preparación de bebidas.
 * Centraliza toda la lógica de preparación en un solo lugar.
 */
public class ServicioPreparacion
{
    /**
     * Prepara una bebida y muestra el proceso completo.
     * @param bebida la bebida a preparar
     * @return descripción detallada del proceso de preparación
     */
    public static String prepararBebida(Bebida bebida) {
        PreparacionStrategy estrategia = bebida.getPreparacionStrategy();
        StringBuilder proceso = new StringBuilder();
        
        // Prepara la bebida base
        proceso.append(estrategia.preparar());
        
        // Si es una bebida decorada, obtenemos la cadena de ingredientes
        if (bebida instanceof IngredienteExtra) {
            proceso.append("\n").append(obtenerIngredientesExtra((IngredienteExtra) bebida));
        }
        
        return proceso.toString();
    }
    
    /**
     * Obtiene la cadena de ingredientes extra en orden correcto.
     * @param ingrediente el ingrediente extra más externo
     * @return cadena con todos los ingredientes extra
     */
    private static String obtenerIngredientesExtra(IngredienteExtra ingrediente) {
        StringBuilder ingredientes = new StringBuilder();
        Bebida bebidaActual = ingrediente;
        
        // Recorremos la cadena de decoradores
        while (bebidaActual instanceof IngredienteExtra) {
            IngredienteExtra extra = (IngredienteExtra) bebidaActual;
            ingredientes.insert(0, "   → Añadiendo " + extra.getNombreExtra() + " (+$" + extra.getPrecioExtra() + ")\n");
            bebidaActual = extra.getBebida();
        }
        
        return ingredientes.toString();
    }
}
