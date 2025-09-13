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
}