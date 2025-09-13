
public abstract class IngredienteExtra implements Bebida
{
    protected Bebida bebida;
    protected double precioExtra;
    protected String nombreExtra;
    
    public IngredienteExtra(Bebida bebida, double precioExtra, String nombreExtra) {
        this.bebida = bebida;
        this.precioExtra = precioExtra;
        this.nombreExtra = nombreExtra;
    }
    
    public double getPrecio() {        
        return bebida.getPrecio() + precioExtra;
    }
    
    public String getNombre() {
        return bebida.getNombre() + " con " + nombreExtra;
    }
    
    public String getDescripcion() {
        return bebida.getDescripcion() + " + " + nombreExtra + " (+$" + precioExtra + ")";
    }
}