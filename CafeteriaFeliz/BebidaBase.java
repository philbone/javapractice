
class BebidaBase implements Bebida
{
    protected String nombre;
    protected double precioBase;
    protected PreparacionStrategy preparacionStrategy;

    public BebidaBase(String nombre, double precioBase, PreparacionStrategy strategy) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.preparacionStrategy = strategy;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precioBase;
    }

    public String getDescripcion() {
        return preparacionStrategy.preparar() + " " + nombre + " - $" + precioBase;
    }
}