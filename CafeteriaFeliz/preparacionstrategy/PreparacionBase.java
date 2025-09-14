package preparacionstrategy;

/**
 * Clase abstracta base para todas las estrategias de preparación.
 * Implementa los métodos comunes de la interfaz.
 */
public abstract class PreparacionBase implements PreparacionStrategy
{    
    /**
    * {@inheritDoc}
    */
   @Override
    public String preparar() {
        AnimacionPreparacion.mostrarAnimacion(
            getPasosPreparacion(),
            getNombrePreparacion(),
            getTiempoPreparacion()
            );
        return getNombrePreparacion() + " listo! Tiempo: " + getTiempoPreparacion() + "s";
    }
    
    /**
    * {@inheritDoc}
    */
   @Override
    public String getDescripcionBreve() {
        return getNombrePreparacion() + " (Preparación: " + getTiempoPreparacion() + "s)";
    }
}