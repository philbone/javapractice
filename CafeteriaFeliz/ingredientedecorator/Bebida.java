package ingredientedecorator;

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
    String getNombre();
    
    /**
     * Obtiene el precio actual de la bebida.
     * @return el precio de la bebida en CLP
     */
    double getPrecio();
    
    /**
     * Obtiene una descripción completa de la bebida.
     * @return descripción detallada con todos los ingredientes
     */
    String getDescripcion();
}