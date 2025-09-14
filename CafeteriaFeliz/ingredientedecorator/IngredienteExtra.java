package ingredientedecorator;

import preparacionstrategy.PreparacionStrategy;

/**
 * Clase abstracta que representa un ingrediente extra que puede añadirse a una bebida.
 * Implementa el patrón Decorator para extender funcionalidades de forma dinámica.
 */
public abstract class IngredienteExtra implements Bebida
{
    protected Bebida bebida;
    protected double precioExtra;
    protected String nombreExtra;
    
    /**
     * Constructor para crear un ingrediente extra.
     * @param bebida la bebida a decorar
     * @param precioExtra el precio adicional del ingrediente
     * @param nombreExtra el nombre del ingrediente extra
     */
    public IngredienteExtra(Bebida bebida, double precioExtra, String nombreExtra) {
        this.bebida = bebida;
        this.precioExtra = precioExtra;
        this.nombreExtra = nombreExtra;
    }
    
    /**
     * {@inheritDoc}
     */
    public double getPrecio() {        
        return bebida.getPrecio() + precioExtra;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getNombre() {
        return bebida.getNombre() + " con " + nombreExtra;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getDescripcion() {
        return bebida.getDescripcion() + " + " + nombreExtra + " (+$" + precioExtra + ")";
    }
    
    /**
     * {@inheritDoc}
     * Devuelve la estrategia de preparación de la bebida decorada.
     */
    public PreparacionStrategy getPreparacionStrategy() {
        return bebida.getPreparacionStrategy();
    }    
}