package ingredientedecorator;

import preparacionstrategy.PreparacionStrategy;

/**
 * Clase que representa una bebida base sin ingredientes extra.
 * Implementa la interfaz Bebida y utiliza el patrón Strategy para la preparación.
 */
public class BebidaBase implements Bebida
{
    protected double precioBase;
    protected PreparacionStrategy preparacionStrategy;
    
    /**
     * Constructor para crear una nueva bebida base.
     * @param nombre el nombre de la bebida
     * @param precioBase el precio base en CLP
     * @param strategy la estrategia de preparación específica
     */
    public BebidaBase(double precioBase, PreparacionStrategy strategy) {        
        this.precioBase = precioBase;
        this.preparacionStrategy = strategy;
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
        return preparacionStrategy.getDescripcionBreve() + " - $" + precioBase;
    }
    
    /**
     * {@inheritDoc}
     */
    public PreparacionStrategy getPreparacionStrategy() {
        return preparacionStrategy;
    }
}