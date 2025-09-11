
public class Pastelero
{
    private String rut;
    private int nroPastelero;
    private String nombre;
    private String fechaIngreso;
    private String especialidad;

    public Pastelero(String rut, int nroPastelero, String nombre, String fechaIngreso, String especialidad) {
        this.rut = rut;
        this.nroPastelero = nroPastelero;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.especialidad = especialidad;
    }

    public boolean esValido() {
        return nombre != null && !nombre.isEmpty() && fechaIngreso.length() == 8;
    }
    
    public String getNombre() {
        return nombre;
    }
}
