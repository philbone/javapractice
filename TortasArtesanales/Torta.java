
public class Torta
{
    private int codigo;
    private String nombre;
    private String tamano;
    private String sabor;
    private String decoracion;
    private double precioUnitario;

    public Torta(int codigo, String nombre, String tamano, String sabor, String decoracion, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tamano = tamano;
        this.sabor = sabor;
        this.decoracion = decoracion;
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public boolean esValida() {
        return (tamano.equals("8 porciones") || tamano.equals("12 porciones") || tamano.equals("20 porciones")) &&
               (sabor.equals("Vainilla") || sabor.equals("Chocolate") || sabor.equals("Pistacho") || sabor.equals("Tres Leches")) &&
               (decoracion.equals("Simple") || decoracion.equals("Personalizada") || decoracion.equals("Temática"));
    }
}