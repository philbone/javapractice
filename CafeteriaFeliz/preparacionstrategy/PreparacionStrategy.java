package preparacionstrategy;

/**
 * Interfaz que define la estrategia de preparación para diferentes tipos de bebidas.
 * Patrón Strategy para variar el algoritmo de preparación.
 */
public interface PreparacionStrategy
{
    /**
     * Ejecuta el proceso de preparación específico para cada tipo de bebida.
     * @return descripción del proceso de preparación
     */
    public String preparar();
    
    /**
     * Obtiene el nombre de la preparación.
     * @return el nombre de la preparación
     */
    public String getNombrePreparacion();
    
    /**
     * Obtiene el tiempo estimado de preparación en segundos.
     * @return tiempo de preparación en segundos
     */
    public int getTiempoPreparacion();
    
    /**
     * Obtiene los pasos necesarios para ejecutar la preparación.
     * @return lista con los pasos de la preparación
     */
    public String[] getPasosPreparacion();
    
    /**
     * Obtiene una descripción breve del proceso.
     * @return descripción breve para la orden
     */
    public String getDescripcionBreve();       
}