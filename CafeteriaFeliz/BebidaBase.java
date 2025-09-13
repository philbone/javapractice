/**
 * Clase que representa una bebida base sin ingredientes extra.
 * Implementa la interfaz Bebida y utiliza el patrón Strategy para la preparación.
 */
class BebidaBase implements Bebida
{
    protected String nombre;
    protected double precioBase;
    protected PreparacionStrategy preparacionStrategy;
    
    /**
     * Constructor para crear una nueva bebida base.
     * @param nombre el nombre de la bebida
     * @param precioBase el precio base en CLP
     * @param strategy la estrategia de preparación específica
     */
    public BebidaBase(String nombre, double precioBase, PreparacionStrategy strategy) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.preparacionStrategy = strategy;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * {@inheritDoc}
     */
    public double getPrecio() {
        return precioBase;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getDescripcion() {
        return preparacionStrategy.preparar() + " " + nombre + " - $" + precioBase;
    }
}