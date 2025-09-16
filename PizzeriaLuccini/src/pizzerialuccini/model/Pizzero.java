package pizzerialuccini.model;

/**
 *
 * @author felipe
 */
public class Pizzero
{
    private String rut;
    private int nroPizzero;
    private String nombre;
    private String fechaIngreso;
    private String especialidad;

    public Pizzero(String rut, int nroPizzero, String nombre, String fechaIngreso, String especialidad) {
        this.rut = rut;
        this.nroPizzero = nroPizzero;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }
}
