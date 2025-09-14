package ingredientedecorator;

import preparacionstrategy.PreparacionStrategy;

/**
 * Interfaz que representa una bebida en el sistema de la cafetería.
 * Define los métodos básicos que toda bebida debe implementar.
 */
public interface Bebida
{
    /**
     * Obtiene el nombre de la bebida.
     * @return el nombre de la bebida
     */
    public String getNombre();
    
    /**
     * Obtiene el precio actual de la bebida.
     * @return el precio de la bebida en CLP
     */
    public double getPrecio();
    
    /**
     * Obtiene una descripción completa de la bebida.
     * @return descripción detallada con todos los ingredientes
     */
    public String getDescripcion();
    
    /**
     * Obtiene la estrategia de preparación de la bebida.
     * @return la estrategia de preparación
     */
    PreparacionStrategy getPreparacionStrategy();
}